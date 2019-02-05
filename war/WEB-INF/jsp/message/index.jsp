<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="wym" tagdir="/WEB-INF/tags/layout"%>
<wym:loggedin title="${title}">
	<div data-role="page" data-theme="${f:h(theme)}">
		<header data-role="header" data-theme="${f:h(theme_header)}">
			<h1>${f:h(user.nickname)}さんが受け取ったメッセージ</h1>
			<div data-role="controlgroup" data-type="horizontal" class="control">
				<a href="${signoutURL}" data-role="button" data-icon="check" rel="external">Sign out</a>
				<a href="/words/imet" data-role="button" data-icon="back">back</a>
				<%--
				<a href="/account/" data-role="button" data-icon="gear">account</a>
				--%>
			</div>
			<div data-role="controlgroup">
			</div>
		</header>
		<div data-role="content">
			<div class="wordsyoumet">
				<ul data-role="listview" data-filter="true" data-inset="false">
					<c:forEach var="m" items="${messageList}">
					<li><a href="/message/received/${m.id}">
						<h3>${f:h(m.message)}</h3>
					</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<%--
		<footer data-role="footer">
			<div data-role="controlgroup" data-type="horizontal" class="control">
				<a href="/" data-role="button" data-mini="true" data-icon="back" data-iconpos="notext">Top</a>
				<a href="/words/add" data-role="button" data-icon="plus" data-iconpos="notext">add</a>
				<a href="/account/" data-role="button" data-icon="gear" data-iconpos="notext">account</a>
			</div>
		</footer>
		 --%>
	</div>
</wym:loggedin>
