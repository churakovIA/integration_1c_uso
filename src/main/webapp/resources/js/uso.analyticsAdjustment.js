const ajaxUrl = "ajax/analyticsAdjustment/";

// http://api.jquery.com/jQuery.ajax/#using-converters
$.ajaxSetup({
    converters: {
        "text json": function (stringData) {
            const json = JSON.parse(stringData);
            $(json).each(function () {
                this.dateTime = prettyDateTime(this.dateTime);
                this.statusDateTime = prettyDateTime(this.statusDateTime);
            });
            return json;
        }
    }
});

function prettyDateTime(dateTime){
    let res = dateTime.replace('T', ' ').substr(0, 16);
    res = res.replace('0001-01-01 00:00', ' ');
    return res;
}

$(function () {
    $("#datatable").DataTable({
        "serverSide": true,
        "info": false,
        "ajax": {"url": ajaxUrl, "dataSrc": ""},
        "columns": [
            {"data": null,
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<img src='resources/images/" + (row.posted ? "document_posted" :
                            row.marked ? "document_marked": "document") + ".png'>";
                    }
                    return data;
                }
            },
            {"data": "dateTime"},
            {"data": "number"},
            {"data": "status"},
            {"data": "statusDateTime"},
            {"data": "comment"}
        ]
    });
});