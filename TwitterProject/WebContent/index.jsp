<%-- <%@ include file="header.jsp"%> --%>
<jsp:include page="header.jsp" /> 
<script type="text/javascript">
	$(function() {
		getTwitterData();//default - when we load page first time...
	});
</script>
<%@ include file="banner.jsp"%>

<section class="main">
	<div class="query-topics">
		<ul>
			<li><a href="javascript:void(0);" class="query" id="documentry">Documentary</a></li>
			<li><a href="javascript:void(0);" class="query" id="action">Action</a></li>
			<li><a href="javascript:void(0);" class="query" id="adventure">Adventure</a></li>
			<li><a href="javascript:void(0);" class="query" id="blackfriday">BlackFriday</a></li>
		</ul>
	</div>
	<div class="query-data" id="query-data"></div>
	<div class="clear"></div>
</section>

<jsp:include page="footer.jsp" /> 