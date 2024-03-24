<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring Boot Email using FreeMarker</title>
</head>
<body style="font-family: 'Open Sans', sans-serif; line-height: 1.25;">
<div style="margin-top: 10px">Greetings, Marija</div>
<br/>
<div>Have a nice day..!</div>

<table style="border: 1px solid #0a0909; border-collapse: collapse; margin: 0; padding: 0; width: 100%; table-layout: fixed;">
    <caption style="font-size: 1.5em; margin: .5em 0 .75em;">Statement Summary</caption>
    <thead>
    <tr style="background-color: #f8f8f8; border: 4px solid #100e0e; padding: .35em;">
        <th scope="col" style="padding: .625em; text-align: center; font-size: .85em; letter-spacing: .1em; text-transform: uppercase;">Date</th>
        <th scope="col" style="padding: .625em; text-align: center; font-size: .85em; letter-spacing: .1em; text-transform: uppercase;">Category</th>
        <th scope="col" style="padding: .625em; text-align: center; font-size: .85em; letter-spacing: .1em; text-transform: uppercase;">Type</th>
        <th scope="col" style="padding: .625em; text-align: center; font-size: .85em; letter-spacing: .1em; text-transform: uppercase;">Amount</th>
        <th scope="col" style="padding: .625em; text-align: center; font-size: .85em; letter-spacing: .1em; text-transform: uppercase;">Currency</th>

    </thead>
    <tbody>
    <tr style="background-color: #f8f8f8; border: 4px solid #100e0e; padding: .35em;">
        <#list ccss as c>
            <td data-label="Date" style="padding: .625em; text-align: center;">${c.dateFrom()}</td>
            <td data-label="Category" style="padding: .625em; text-align: center;">${c.category()}</td>
            <td data-label="Category" style="padding: .625em; text-align: center;">${c.transactionType()}</td>
            <td data-label="Category" style="padding: .625em; text-align: center;">${c.amount()}</td>
            <td data-label="Category" style="padding: .625em; text-align: center;">${c.currency()}</td>

        </#list>
    </tr>
    </tbody>
</table>
</body>
</html>