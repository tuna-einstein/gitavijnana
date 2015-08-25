<%@page import="com.usp.gitavijnana.shared.model.TransitionInfo"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="org.slim3.datastore.Datastore"%>
<%@ page import="com.usp.gitavijnana.server.meta.SlokaMeta"%>
<%@ page import="com.usp.gitavijnana.shared.model.Sloka"%>
<%@ page import="com.usp.gitavijnana.server.meta.TransitionInfoMeta"%>
<%@ page import="com.usp.gitavijnana.shared.model.TransitionInfo"%>

<%@ page import="java.util.List"%>



<%
	String chapter = request.getParameter("chapter").trim();
	String slokaNum = request.getParameter("slokaNum").trim();
	String uniqueId = "id_" + chapter + "_" + slokaNum;

	Integer chapterInt = Integer.valueOf(chapter);

	SlokaMeta meta = SlokaMeta.get();
	Sloka result = Datastore
			.query(meta)
			.filter(meta.chapter.equal(Integer.valueOf(chapter)),
					meta.slokaNum.equal(Integer.valueOf(slokaNum)))
			.asSingle();
	if (result == null) {
		result = new Sloka();
	}

	/* String nextChapter = request.getParameter("nc").trim();
	String startSloka = request.getParameter("sl").trim();
	String endSloka = request.getParameter("el").trim(); */
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

	<%
		String currentStart = request.getParameter("cs").trim();
		String currentEnd = request.getParameter("ce").trim();
		Integer csi = Integer.valueOf(currentStart);
		Integer cei = Integer.valueOf(currentEnd);

		TransitionInfoMeta trnInfoMeta = TransitionInfoMeta.get();
		TransitionInfo trnInfo = Datastore
				.query(trnInfoMeta)
				.filter(trnInfoMeta.chapter.equal(chapterInt),
						trnInfoMeta.start.equal(csi),
						trnInfoMeta.end.equal(cei)).asSingle();

		if (trnInfo == null) {
			trnInfo = new TransitionInfo();
		}
		int currentIndex = trnInfo.getIndex();
		int prevIndex = (currentIndex == 1) ? 18 : currentIndex - 1;
		int nextIndex = (currentIndex == 18) ? 1 : currentIndex + 1;

		TransitionInfoMeta prevMeta = TransitionInfoMeta.get();
		TransitionInfo prev = Datastore.query(prevMeta)
				.filter(prevMeta.index.equal(prevIndex)).asSingle();
		if (prev == null) {
			prev = new TransitionInfo();
		}

		TransitionInfoMeta nextMeta = TransitionInfoMeta.get();
		TransitionInfo next = Datastore.query(nextMeta)
				.filter(nextMeta.index.equal(nextIndex)).asSingle();
		if (next == null) {
			next = new TransitionInfo();
		}
	%>
	<script type="text/javascript">
	
	prevChapter =<%=prev.getChapter()%>;
    prevStart =<%=prev.getStart()%>;
    prevEnd =<%=prev.getEnd()%>;

    nextChapter = <%=next.getChapter()%>;
    nextStart = <%=next.getStart()%>;
    nextEnd = <%=next.getEnd()%>;

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