function PNOnClick() {
    var table, rows, switching, i, x, y, shouldSwitch, PNClicked, PNvalue, comparingNumber;
    PNClicked = document.getElementById("PNClicked");
    PNvalue = PNClicked.value;
    table = document.getElementById("resultTable");
    switching = true;
    if (PNvalue == "False") {
        comparingNumber = 1;
        document.getElementById("PNClicked").value = "True";
    }
    else {
        comparingNumber = -1;
        document.getElementById("PNClicked").value = "False";
    }
    /* Make a loop that will continue until
     no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /* Loop through all table rows (except the
         first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
             one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[0];
            y = rows[i + 1].getElementsByTagName("TD")[0];
            // Check if the two rows should switch place:
            if (x.innerHTML.toLowerCase().localeCompare(y.innerHTML.toLowerCase()) === comparingNumber) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
             and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}
function PartNameOnClick() {
    var table, rows, switching, i, x, y, shouldSwitch, PartNameClicked, PartNameValue, comparingNumber;
    PartNameClicked = document.getElementById("PartNameClicked");
    PartNameValue = PartNameClicked.value;
    table = document.getElementById("resultTable");
    switching = true;
    if (PartNameValue == "False") {
        comparingNumber = 1;
        document.getElementById("PartNameClicked").value = "True";
    }
    else {
        comparingNumber = -1;
        document.getElementById("PartNameClicked").value = "False";
    }
    /* Make a loop that will continue until
     no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /* Loop through all table rows (except the
         first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
             one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[1];
            y = rows[i + 1].getElementsByTagName("TD")[1];
            // Check if the two rows should switch place:
            if (x.innerHTML.toLowerCase().localeCompare(y.innerHTML.toLowerCase()) === comparingNumber) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
             and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

function VendorOnClick() {
    var table, rows, switching, i, x, y, shouldSwitch, VendorClicked, VendorValue, comparingNumber;
    VendorClicked = document.getElementById("VendorClicked");
    VendorValue = VendorClicked.value;
    table = document.getElementById("resultTable");
    switching = true;
    if (VendorValue == "False") {
        comparingNumber = 1;
        document.getElementById("VendorClicked").value = "True";
    }
    else {
        comparingNumber = -1;
        document.getElementById("VendorClicked").value = "False";
    }
    /* Make a loop that will continue until
     no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /* Loop through all table rows (except the
         first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
             one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[2];
            y = rows[i + 1].getElementsByTagName("TD")[2];
            // Check if the two rows should switch place:
            if (x.innerHTML.toLowerCase().localeCompare(y.innerHTML.toLowerCase()) === comparingNumber) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
             and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}
function QtyOnClick() {
    var table, rows, switching, i, x, y, shouldSwitch, QtyClicked, QtyValue, comparingNumber;
    QtyClicked = document.getElementById("QtyClicked");
    QtyValue = QtyClicked.value;
    table = document.getElementById("resultTable");
    switching = true;
    if (QtyValue == "False") {
        comparingNumber = 1;
        document.getElementById("QtyClicked").value = "True";
    }
    else {
        comparingNumber = -1;
        document.getElementById("QtyClicked").value = "False";
    }
    /* Make a loop that will continue until
     no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /* Loop through all table rows (except the
         first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
             one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[3];
            y = rows[i + 1].getElementsByTagName("TD")[3];
            // Check if the two rows should switch place:
            if (x.innerHTML.toLowerCase().localeCompare(y.innerHTML.toLowerCase()) === comparingNumber) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
             and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}
function ShippedOnClick() {
    var table, rows, switching, i, x, y, shouldSwitch, ShippedClicked, ShippedValue, comparingNumber;
    ShippedClicked = document.getElementById("ShippedClicked");
    ShippedValue = ShippedClicked.value;
    table = document.getElementById("resultTable");
    switching = true;
    if (ShippedValue == "False") {
        comparingNumber = 1;
        document.getElementById("ShippedClicked").value = "True";
    }
    else {
        comparingNumber = -1;
        document.getElementById("ShippedClicked").value = "False";
    }
    /* Make a loop that will continue until
     no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /* Loop through all table rows (except the
         first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
             one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[4];
            y = rows[i + 1].getElementsByTagName("TD")[4];
            // Check if the two rows should switch place:
            if (compareDates(x, y) === comparingNumber) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
             and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}
function ReceivedOnClick() {
    var table, rows, switching, i, x, y, shouldSwitch, ReceivedClicked, ReceivedValue, comparingNumber;
    ReceivedClicked = document.getElementById("ReceivedClicked");
    ReceivedValue = ReceivedClicked.value;
    table = document.getElementById("resultTable");
    switching = true;
    if (ReceivedValue == "False") {
        comparingNumber = 1;
        document.getElementById("ReceivedClicked").value = "True";
    }
    else {
        comparingNumber = -1;
        document.getElementById("ReceivedClicked").value = "False";
    }
    /* Make a loop that will continue until
     no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /* Loop through all table rows (except the
         first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
             one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[5];
            y = rows[i + 1].getElementsByTagName("TD")[5];
            // Check if the two rows should switch place:
            if (compareDates(x, y) === comparingNumber) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
             and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}
function compareDates(date1, date2) {
    //calculating the difference between dates
    var difference = Date.parse(date1.textContent, 'MMM dd, yyyy') - Date.parse(date2.textContent, 'MMM dd, yyyy');
    if(difference < 0) return -1; //for comparing
    else if(difference > 0) return 1;
    else return 0;
}
