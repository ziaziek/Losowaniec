<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Generate</title>
    <meta name="layout" content="main">
</head>
<body>
Istnieje ${setsnumber} kombinacji.
Według Twoich kryteriów wybrano ${pickedSetsnumber} z nich.
<div class="setlist">
    <g:each var="set" in="${sets}">
        <div class="setlist_span">
            <g:each var="number" in="${set}">
                <div style="display: table-cell; vertical-align: text-bottom; float:left; width: 35px; height:35px; text-align: center; background-image: url('${resource(dir: 'images', file: 'kolko.png')}');
                background-repeat: no-repeat"><span style="">${number}</span></div>
            </g:each>
            <br/>
        </div>
        <br/>
    </g:each>
</div>
<a href="/index"><button>Powrót</button></a>
</body>
</html>