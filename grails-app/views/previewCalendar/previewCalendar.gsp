<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<!-- // TODO <meta name="layout" content="main"/>-->
	<title>Preview Calendar</title>
</head>
<body>
<div class="body">
	<h1>Preview Calendar</h1>
	<p>To build your calendar, select the topics below that you want to include, then pick a starting month and year:</p>
	<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
	</g:if>
	<g:hasErrors bean="${previewCalendar}">
		<div class="errors">
			<g:renderErrors bean="${previewCalendar}" as="list"/>
		</div>
	</g:hasErrors>
	<g:form action="previewCalendarSubmit" method="post">
		<div class="dialog">
			<table>
				<tbody>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="ids">Topics:</label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: previewCalendar, field: 'ids', 'errors')}">
						<g:checkBoxList name="ids" from="${viewInfo?.activityCategories}" value="${previewCalendar?.activityCategories?.collect{it.id}}" optionKey="id" optionValue="title"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="month">Month:</label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: previewCalendar, field: 'month', 'errors')}">
						<g:select name="month" from="${viewInfo?.months}" value="${previewCalendar?.month}" optionKey="key" optionValue="value" noSelection="${['':'Select starting month ---']}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="year">Year:</label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: previewCalendar, field: 'year', 'errors')}">
						<g:select name="year" from="${viewInfo?.years}" value="${previewCalendar?.year}" noSelection="${['':'Select starting year ---']}"/>
					</td>
				</tr>

				</tbody>
			</table>
		</div>
		<div class="buttons">
			<span class="button"><input class="save" type="submit" value="Preview"/></span>
		</div>
	</g:form>
</div>
</body>
</html>

