package com.test.task.servlets;

import com.test.task.dao.PostgresqlDaoImpl;
import com.test.task.entities.Filter;
import com.test.task.entities.PartEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * It is the main part of application
 * Servlet gets data from jsp page and sends data to jsp page
 */
public class PartsServlet extends HttpServlet {
    final static Logger logger = LogManager.getLogger(PartsServlet.class);

    /**
     * get method opens page
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Entering doGet() method");
        req.setAttribute("parts", new ArrayList<>());
        req.getRequestDispatcher("WEB-INF/pages/PartsFilter.jsp").forward(req, resp);
    }

    /**
     * handling post methods
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Entering doPost() method");
        String action = req.getParameter("action");
        //if actions will be added in the future
        switch (action) {
            case "buildFilter":
                logger.debug("catched buildFuilter action");
                buildFilterHandler(req);
                break;
        }


        req.getRequestDispatcher("WEB-INF/pages/PartsFilter.jsp").forward(req, resp);
    }

    /**
     * This method gets data from db and sends it to HttpServletRequest
     * @param req from doPost()
     */
    private void buildFilterHandler(HttpServletRequest req) {
        Filter filter = buildFilter(req);
        PostgresqlDaoImpl postgresqlDao = new PostgresqlDaoImpl();
        List<PartEntity> partEntities = postgresqlDao.getPartsByFilter(filter);
        req.setAttribute("parts", partEntities);
    }

    /**
     * this methods builds filter using data from jsp page
     * @param req fron doPost()
     * @return filter
     */
    private Filter buildFilter(HttpServletRequest req) {
        Filter filter = new Filter();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        filter.setPN((req.getParameter("PN") == null
                || req.getParameter("PN").isEmpty())
                ? null : req.getParameter("PN"));
        filter.setPartName((req.getParameter("PartName") == null
                || req.getParameter("PartName").isEmpty())
                ? null : req.getParameter("PartName"));
        filter.setVendor((req.getParameter("Vendow") == null
                || req.getParameter("Vendor").isEmpty())
                ? null : req.getParameter("Vendor"));
        filter.setQty((req.getParameter("QTY") == null
                || req.getParameter("QTY").isEmpty()
                || !req.getParameter("QTY").matches("\\d+")) ? null //checking by regex is current string a number
                : Integer.parseInt(req.getParameter("QTY")));
        try {
            if (req.getParameter("afterShipped") != null && req.getParameter("afterShipped")
                    .matches("[A-Z][a-z]{2} \\d\\d?, \\d{4}")) //this regex allows us to check by pattern MMM dd, yyyy
                filter.setShippedAfter(dateFormat.parse(req.getParameter("afterShipped")));
            if (req.getParameter("beforeShipped") != null && req.getParameter("beforeShipped")
                    .matches("[A-Z][a-z]{2} \\d\\d?, \\d{4}"))
                filter.setShippedBefore(dateFormat.parse(req.getParameter("beforeShipped")));
            if (req.getParameter("afterReceived") != null && req.getParameter("afterReceived")
                    .matches("[A-Z][a-z]{2} \\d\\d?, \\d{4}"))
            filter.setReceivedAfter(dateFormat.parse(req.getParameter("afterReceived")));
            if (req.getParameter("beforeReceived") != null && req.getParameter("beforeReceived")
                    .matches("[A-Z][a-z]{2} \\d\\d?, \\d{4}"))
            filter.setReceivedBefore(dateFormat.parse(req.getParameter("beforeReceived")));
        } catch (ParseException e) {
            logger.error("ParseException in buildFuilter method");
            logger.catching(e);
        }
        return filter;
    }

    /**
     * closing all connections
     */
    @Override
    public void destroy() {
        try {
            logger.debug("closing db connection");
            PostgresqlDaoImpl.getStatement().close();
            PostgresqlDaoImpl.getConnection().close();
        } catch (SQLException e) {
            logger.error("Error during closing db connection");
            logger.catching(e);
        }
        super.destroy();
    }
}
