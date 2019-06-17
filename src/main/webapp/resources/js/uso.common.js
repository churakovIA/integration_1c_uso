let context;

function makeEditable(ctx) {
    context = ctx;
    context.datatableApi = $("#datatable").DataTable(
        // https://api.jquery.com/jquery.extend/#jQuery-extend-deep-target-object1-objectN
        $.extend(true, ctx.datatableOpts,
            {
                "ajax": {
                    "url": context.ajaxUrl,
                    "dataSrc": ""
                },
                "paging": true,
                "info": true
            }
        ));
}

function updateTableByData(data) {
    context.datatableApi.clear().rows.add(data).draw();
}
