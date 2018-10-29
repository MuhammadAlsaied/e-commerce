$(function () {

    // setting activeness of navbar items
    switch (title) {
        case "About us":
            $("#about").addClass("active");
            break;
        case "Contact us":
            $("#contact").addClass("active");
            break;
        case "All products":
            $("#list_products").addClass("active");
            break;
        case "home":
            $("#home").addClass("active");
            break;

        default:
            $("#" + title).addClass("active");
    }
    $alert = $('.alert');
    if ($alert.length) {
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 3000
                );
    }
    var $productsTable = $('#productsTable');


    if ($productsTable.length) {

        var jsonUrl = window.root + '/admin-panel/json/list/all';
        console.log(jsonUrl);

        $productsTable.DataTable({
            lengthMenu: [[10, 30, 50, -1], ['10 Records', '30 Records', '50 Records', 'ALL']],
            pageLength: 30,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {data: 'id'},

                {data: 'imageURL',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        return '<img style="height:50px " src="' + window.root
                                + '/assets/images/' + data + '" class="dataTableImg"/>';
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'brand'
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {

                        if (data < 1) {
                            return '<span style="color:red">Out of Stock!</span>';
                        }

                        return data;

                    }
                },
                {
                    data: 'price',
                    mRender: function (data, type, row) {
                        return  data;
                    }
                },
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        if (data) {
                            str += '<label class="switch"> <input type="checkbox" value="' + row.id + '" checked="checked">  <div class="slider round"> </div></label>';

                        } else {
                            str += '<label class="switch"> <input type="checkbox" value="' + row.id + '">  <div class="slider round"> </div></label>';
                        }

                        return str;
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {

                        var str = '';
                        str += '<a href="'
                                + window.root
                                + '/admin-panel/product/'
                                + data
                                + '" class="btn btn-primary"><span class="fa fa-pencil"></span></a> &#160;';

                        return str;
                    }
                }
            ],

            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function () {
                    var dText = (this.checked) ? 'You want to activate the Product?' : 'You want to de-activate the Product?';
                    var checked = this.checked;
                    var checkbox = $(this);
                    debugger;
                    bootbox.confirm({
                        size: 'medium',
                        title: 'Product Activation/Deactivation',
                        message: dText,
                        callback: function (confirmed) {
                            if (confirmed) {
                                $.ajax({
                                    type: 'GET',
                                    url: window.root + '/admin-panel/product/' + checkbox.prop('value') + '/activation',
                                    timeout: 100000,
                                    success: function (data) {
                                        bootbox.alert(data);
                                    },
                                    error: function (e) {
                                        bootbox.alert('ERROR: ' + e);
                                        //display(e);
                                    }
                                });
                            } else {
                                checkbox.prop('checked', !checked);
                            }
                        }
                    });
                });

            }
        });
    }



});