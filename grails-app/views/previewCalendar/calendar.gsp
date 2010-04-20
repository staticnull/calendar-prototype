<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="layout" content="main"/>
	<title>Preview Calendar</title>
	%{-- TODO <jqueryCalendar:monthResources/>--}%
	%{--<resource:calendarMonthView/>--}%
	<link rel='stylesheet' type='text/css' href='/css/fullcalendar.css'/>
	<script type='text/javascript' src='/js/jquery/jquery.js'></script>
	<script type='text/javascript' src='/js/jquery/ui.core.js'></script>
	<script type='text/javascript' src='/js/jquery/ui.draggable.js'></script>
	<script type='text/javascript' src='/js/jquery/ui.resizable.js'></script>
	<script type='text/javascript' src='/js/fullcalendar.min.js'></script>
	<script type='text/javascript'>
		$(document).ready(function() {
			$('#calendar').fullCalendar({

				editable: false,

				events: "/fullCalendar/calendar?ids=1&startDate=2/01/2011",

				//TODO remove?	eventDrop: function(event, delta) {
				//					alert(event.title + ' was moved ' + delta + ' days\n' +
				//						  '(should probably update your database)');
				//				},

				loading: function(bool) {
					if (bool) $('#loading').show();
					else $('#loading').hide();
				}

			});
		});
	</script>
	<style type='text/css'>
	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	}

	#loading {
		position: absolute;
		top: 5px;
		right: 5px;
	}

	#calendar {
		width: 900px;
		margin: 0 auto;
	}
	</style>
</head>
<body>
<div class="body">
	<h1>Calendar - <g:formatMonth format="MMMMM yyyy" value="${viewInfo.utilDate}"/></h1>
	<ul>
		<g:each var="events" in="${viewInfo.events}" status="i">
			<li>
				${events.title}
			</li>
		</g:each>
	</ul>
	%{--<div>--}%
	%{-- TODO More info http://www.grails.org/RichUI+Plugin#CalendarMonthView --}%
	%{-- TODO <richui:calendarMonthView items="${viewInfo.events}" createLink="true"--}%
	%{--constraintDateFields="['startDate-endDate', 'startDate', 'endDate']" displayField="title" teaser="true" teaserLength="20" weekOfYear="true" month="${viewInfo.utilDate}" action="show"/>--}%
	%{--<richui:calendarMonthView items="${viewInfo.events}" createLink="false" displayField="title" teaser="false" weekOfYear="false" month="${viewInfo.utilDate}"/>--}%
	%{--</div>--}%
	%{--<div>--}%
	%{-- TODO More info http://www.grails.org/plugin/jquery-calendar#CalendarMonthView--}%
	%{--<jqueryCalendar:month--}%
	%{--year="${year}"--}%
	%{--month="${month}"--}%
	%{--weekStart="${1}"--}%
	%{--draggable="${true}"--}%
	%{--readonly="${readOnly}"--}%
	%{--fixedWeeks="${true}"--}%
	%{--abbrevDayHeadings="${false}"--}%
	%{--title="${true}"--}%
	%{--showTime="guess"/>--}%
	%{--</div>--}%
	<div>
		<div id='loading' style='display:none'>loading...</div>
		<div id='calendar'>calendar</div>
	</div>
	<div class="buttons">
		<span class="button"><g:link controller="previewCalendar" action="index">Cancel</g:link></span>
	</div>
</div>
</body>
</html>