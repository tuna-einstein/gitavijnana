<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="org.slim3.datastore.Datastore"%>
<%@ page import="com.usp.gitavijnana.server.meta.SlokaMeta"%>
<%@ page import="com.usp.gitavijnana.shared.model.Sloka"%>
<%@ page import="java.util.List"%>



<%
	String chapter = request.getParameter("chapter").trim();
	String slokaNum = request.getParameter("slokaNum").trim();
	String uniqueId = "id_" + chapter + "_" + slokaNum;

	SlokaMeta meta = SlokaMeta.get();
	Sloka result = Datastore
			.query(meta)
			.filter(meta.chapter.equal(Integer.valueOf(chapter)),
					meta.slokaNum.equal(Integer.valueOf(slokaNum)))
			.asSingle();
	if (result == null) {
		result = new Sloka();
	}
%>



<div>
	<table id="table_<%=uniqueId%>" align="center">
		<tr class="headerClass" id="header_<%=uniqueId%>">
			<td colspan="2"></td>
		</tr>
		<tr id="chapterTitle_<%=uniqueId%>">
			<td align="center" class="chapterTitle" colspan="2">Chapter- <%=chapter%>,
				Verse-<%=slokaNum%>
			</td>
		</tr>
		<tr valign="middle" id="audioLink_<%=uniqueId%>">
			<td align="center" colspan="2"><audio controls>
					<source src="<%=result.getAudioLink()%>" type="audio/mpeg">
				</audio></td>
		</tr>
		<tr class="englishTranslation" id="englishTranslation_<%=uniqueId%>">
			<td valign="top" align="left" colspan="2"><%=result.getEnglishTranslation()%>
			</td>
		</tr>

		<tr id="sloka_<%=uniqueId%>">

			<td class="sanskritSloka" valign="top" align="center"
				id="sanskritSloka_<%=uniqueId%>"><%=result.getSanskrit().replaceAll("\n", "<br/>")%>
			<td class="englishSloka" valign="top" align="center"><%=result.getEnglish().replaceAll("\n", "<br/>")%>
			</td>
		</tr>



		<tr class="descriptionStyle" id="descriptionStyle_<%=uniqueId%>">
			<td valign="top" align="left" colspan="2"><%=result.getSanskritToEnglish()%>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
	$(function() {
	$("#bhagvadgita_header").html("Bhagvad Gita");
    });
    
    $(function() {
     var documentWidth = $( document ).width();
     var documentHeight = $( document ).height();
     
     $("#header_<%=uniqueId%>").css("height", documentHeight * 0.1);
     $("#chapterTitle_<%=uniqueId%>").css("height", documentHeight * 0.05);
     $("#audioLink_<%=uniqueId%>").css("height", documentHeight * 0.1);
     $("#englishTranslation_<%=uniqueId%>").css("height", documentHeight * 0.2);
     $("#sloka_<%=uniqueId%>").css("height", documentHeight * 0.3);
     $("#descriptionStyle_<%=uniqueId%>").css("height", documentHeight * 0.2);
     
    });
	</script>
</div>