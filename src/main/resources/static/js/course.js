$(document).ready(function () {
    var qsParm = new Array();
    var query = window.location.search.substring(1);
    var parms = query.split('&');
    for (var i = 0; i < parms.length; i++) {
        var pos = parms[i].indexOf('=');
        if (pos > 0) {
            var key = parms[i].substring(0, pos);
            var val = parms[i].substring(pos + 1);
            qsParm[key] = val;
        }
    }

    $.ajax({
        url: '/course/' + qsParm.id,
        type: 'get',
        success: function (data) {

            $("#title").text(data.title);
            $("#description").text(data.description);

            var table_body = '<table border="1">';
            table_body += '<thead>';
            table_body += '<tr>';
            table_body += '<td>';
            table_body += 'Name';
            table_body += '</td>';
            table_body += '</tr>';
            table_body += '</thead>';

            for (var i = 0; i < data.students.length; i++) {
                table_body += '<tr>';
                table_body += '<td>';
                table_body += data.students[i].name;
                table_body += '</td>';
                table_body += '<td>';
                table_body += '<a href="#" id=' + data.students[i].id + ' onclick="return call(this);">info</a>';
                table_body += '</td>';
                table_body += '</tr>';
            }

            table_body += '</table>';
            $('#tableDiv').html(table_body);
        },
        error: function (xhr, str) {
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
});

function call(Element) {
    window.location = 'student.html?id=' + Element.id;
}