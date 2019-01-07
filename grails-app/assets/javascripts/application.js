// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
    $(".numbers_picker").hide();
}

$("#radios").click(function () {

    var rtchecked = $("#radio_tak").is(':checked');
    var system_txt = $('input[name="n_system"]');
    var hm = $('input[name="n_all"]').val();

    if(rtchecked==false){
        $(".numbers_picker").load("/index/numberspicker", {"howmany":hm});
        $(".numbers_picker").fadeIn();
        system_txt.val("0");
    } else {
        $(".numbers_picker").fadeOut();
    }
    system_txt.prop('disabled', !rtchecked);

});


