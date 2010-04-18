<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<!-- // TODO <meta name="layout" content="main"/>-->
	<title>Preview Calendar</title>
</head>
<body>
<div class="body">
	<h1>Calendar - ${viewInfo.month}/${viewInfo.year}</h1>
	<ul>
	<g:each var="events" in="${viewInfo.events}" status="i">
		<li>
			${events.title}
		</li>
	</g:each>
	</ul>

	<div>
		<resource:calendarMonthView/>
		<richui:calendarMonthView items="${viewInfo.events}" displayField="title" weekOfYear="false" month="${month}"/>
	</div>
	<br/>
</div>
</body>
</html>