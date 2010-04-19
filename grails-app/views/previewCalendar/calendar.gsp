<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<!-- // TODO <meta name="layout" content="main"/>-->
	<title>Preview Calendar</title>
</head>
<body>
<div class="body">
	<h1>Calendar - <g:formatMonth date="${viewInfo.utilDate}" /></h1>
	<ul>
		<g:each var="events" in="${viewInfo.events}" status="i">
			<li>
				${events.title}
			</li>
		</g:each>
	</ul>

	<div>
		%{-- TODO More info http://www.grails.org/RichUI+Plugin#CalendarMonthView --}%
		<resource:calendarMonthView/>
		%{-- TODO <richui:calendarMonthView items="${viewInfo.events}" createLink="true"--}%
				%{--constraintDateFields="['startDate-endDate', 'startDate', 'endDate']" displayField="title" teaser="true" teaserLength="20" weekOfYear="true" month="${viewInfo.utilDate}" action="show"/>--}%
		<richui:calendarMonthView items="${viewInfo.events}" createLink="false" displayField="title" teaser="false" weekOfYear="false" month="${viewInfo.utilDate}" />
	</div>
	<br/>
</div>
</body>
</html>