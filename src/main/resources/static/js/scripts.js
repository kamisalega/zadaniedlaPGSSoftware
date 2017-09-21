$(document).ready(function () {
    $('.delete-music').on('click', function () {
        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'remove';
        /*]]>*/

        var id = $(this).attr('id');

        bootbox.confirm({
            message: "Czy napewno chcesz usunąć tą piosenkę? Nie można będzie tego cofnąć.",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Cancel'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function (confirmed) {
                if (confirmed) {
                    $.post(path, {'id':id}, function (res) {
                        location.reload();
                    });
                }
            }
        });
    });




    // $('.checkboxMusic').click(function () {
    //     var id = $(this).attr('id');
    //     if (this.checked) {
    //         musicIdList.push(id);
    //     } else {
    //         musicIdList.splice(musicIdList.indexOf(id), 1);
    //     }
    //
    // });

    $('#deleteSelected').click(function () {
        var idList = $('.checkboxMusic');
        var musicIdList = [];
        for (var i = 0; i < idList.length; i++) {
            if (idList[i].checked == true) {
                musicIdList.push(idList[i]['id'])
            }
        }

        console.log(musicIdList);

        /*<![CDATA[*/
        var path = /*[[@{/}]]*/ 'removeList';
        /*]]>*/
        bootbox.confirm({
            message: "Czy jesteś pewien że chcesz usnąć wybraną piosenkę? Tego nie będzie można cofnąć.",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times></i> Cancel'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function (confirmed) {
                if (confirmed) {
                    $.ajax({
                        type: 'POST',
                        url: path,
                        data: JSON.stringify(musicIdList),
                        contentType: "application/json",
                        success: function (res) {
                            console.log(res);
                            location.reload()
                        },
                        error: function (res) {
                            console.log(res);
                            location.reload();
                        }
                    });
                }
            }
        });
    });

    $("#selectAllMusic").click(function () {
        if ($(this).prop("checked") == true) {
            $(".checkboxMusic").prop("checked", true);
        } else if ($(this).prop("checked") == false) {
            $(".checkboxMusic").prop("checked", false);
        }
    })
});
