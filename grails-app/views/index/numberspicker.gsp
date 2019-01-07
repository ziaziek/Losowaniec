<g:each status="i" var="n" in="${numbers}">
    <div class="liczba">
        <span class="liczba_img"><asset:image src="kolko.png" id="liczba_img_${n}"/> ${n}</span>
    </div>

</g:each>

<g:javascript>
    $(".liczba_img img").click(function () {
        var imageattr = $(this).attr('src');
        var picked = $("#picked_numbers").val();
        if(imageattr=='assets/kolko.png'){
            $(this).attr('src', 'assets/kolko_tick.png');
            picked+=" "+$(this).parent().text();
        } else {
            $(this).attr('src', 'assets/kolko.png');
            picked = picked.replace(" "+$(this).parent().text(), "");
        }
        $("#picked_numbers").val(picked);
    });
</g:javascript>