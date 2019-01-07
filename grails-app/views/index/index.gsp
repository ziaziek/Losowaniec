<!doctype html>
<html>
<head>
    <title>Losowaniec</title>
    <meta name="layout" content="main">
</head>
<body>

<h2>Losowaniec</h2>
<div >
    <div class="main_form">
        <form name="mainform" method="post" action="index/generate">
            <table>
                <tr><td>Z ilu liczb losowanie</td><td><input type="text" name="n_all"/> </td></tr>
                <tr><td>Ilość liczb losowanych</td><td><input type="text" name="n_los"/></td></tr>
                <tr><td>Chybił trafił</td><td><span id="radios"><span><input type="radio" name="automatic" id="radio_tak" value="y"/>Tak</span><span style="padding-left: 30px;"><input type="radio" name="automatic" value="n"/>Nie</span></span></td></tr>
                <tr><td>System</td><td><input type="text" name="n_system"/></td></tr>
                <tr><td>Użyj</td><td><input type="text" name="n_sets" value="100"/>% wyników</td></tr>
            </table>
            <input type="submit" value="Wyślij"/>
            <g:hiddenField name="picked_numbers" id="picked_numbers"/>
        </form>
    </div>

    <div class="numbers_picker">

    </table>

    </div>
</div>


</body>
</html>