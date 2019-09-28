$(document).ready(function () {
    $.ajax({
        url: '/courses',
        type: 'get',
        success: function (data) {
            var table_body = '<table border="1">';
            table_body += '<thead>';
            table_body += '<tr>';
            table_body += '<td>';
            table_body += 'Title';
            table_body += '</td>';
            table_body += '<td>';
            table_body += 'Description';
            table_body += '</td>';
            table_body += '<td>';
            table_body += '';
            table_body += '</td>';
            table_body += '</tr>';
            table_body += '</thead>';

            for (var i = 0; i < data.length; i++) {
                table_body += '<tr>';
                table_body += '<td>';
                table_body += data[i].title;
                table_body += '</td>';
                table_body += '<td>';
                table_body += data[i].description;
                table_body += '</td>';
                table_body += '<td>';
                table_body += '<a href="#" id=' + data[i].id + ' onclick="return call(this);">info</a>';
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
    window.location = 'course.html?id=' + Element.id;
}