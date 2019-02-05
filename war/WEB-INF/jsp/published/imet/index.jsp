<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="wym" tagdir="/WEB-INF/tags/layout"%>
<wym:loggedin title="${title}">
	<div data-role="page" data-theme="${f:h(theme)}">
		<header data-role="header" data-theme="${f:h(theme_header)}">
			<h1>${f:h(title)}さんが出会ったことば</h1>
			<c:if test="${! empty(user)}">
			<%-- TODO テンプレートをインクルードする --%>
			<div data-role="controlgroup" data-type="horizontal" class="control">
				<a href="${signoutURL}" data-role="button" data-icon="check" rel="external">Sign out</a>
				<%--
				<a href="/account/" data-role="button" data-icon="gear">account</a>
				--%>
			</div>
			</c:if>
		</header>
		<div data-role="content">
			<div class="wordsyoumet">
				<p>これまでに投稿されたことば</p>
				<ul data-role="listview" data-filter="true" data-inset="false">
					<c:forEach var="e" items="${wordList}">
					<li><a href="/published/imet/${nickname}/${e.id}">
						<h3><q>${f:h(e.word)}</q></h3>
						<div class="author">
							<span class="author">${f:h(e.author)}</span>
							<c:if test="${! empty e.cite}"><cite>${f:h(e.cite)}</cite></c:if>
						</div>
						<p>${f:h(e.desc)}</p><!-- TODO: 文字を途中で切る -->
					</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<%--
		<footer data-role="footer">
			<a href="/" data-role="button" data-mini="true" data-inline="true" data-icon="back">Top</a>
		</footer>
		--%>
	</div>
</wym:loggedin>
