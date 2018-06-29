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
 * Created by lollipop on 28.06.2018.
 */
public class PartsServlet extends HttpServlet {
    final static Logger logger = LogManager.getLogger(PartsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Entering doGet() method");
        req.setAttribute("parts", new ArrayList<>());
        req.getRequestDispatcher("WEB-INF/pages/PartsFilter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Entering doPost() method");
        String action = req.getParameter("action");

        switch (action) {
            case "buildFilter":
                logger.debug("catched buildFuilter action");
                buildFilterHandler(req);
                break;
        }


        req.getRequestDispatcher("WEB-INF/pages/PartsFilter.jsp").forward(req, resp);
    }

    private void buildFilterHandler(HttpServletRequest req) {
        Filter filter = buildFilter(req);
        PostgresqlDaoImpl postgresqlDao = new PostgresqlDaoImpl();
        List<PartEntity> partEntities = postgresqlDao.getPartsByFilter(filter);
        req.setAttribute("parts", partEntities);
    }

    private Filter buildFilter(HttpServletRequest req) {
        Filter filter = new Filter();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        filter.setPN(req.getParameter("PN"));
        filter.setPartName(req.getParameter("PartName"));
        filter.setVendor(req.getParameter("Vendor"));
        filter.setQty((req.getParameter("QTY") == null
                || req.getParameter("QTY").isEmpty()
                || !req.getParameter("QTY").matches("\\d+")) ? null
                : Integer.parseInt(req.getParameter("QTY")));
        try {
            if (req.getParameter("afterShipped") != null && req.getParameter("afterShipped")
                    .matches("[A-Z][a-z]{2} \\d\\d?, \\d{4}"))
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
