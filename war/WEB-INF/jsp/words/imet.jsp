<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="wym" tagdir="/WEB-INF/tags/layout"%>
<wym:loggedin title="${title}">
	<div data-role="page" data-theme="${f:h(theme)}">
		<header data-role="header" data-theme="${f:h(theme_header)}">
			<h1>${f:h(user.nickname)}さんが出会ったことば</h1>
			<div data-role="controlgroup" data-type="horizontal" class="control">
				<a href="${signoutURL}" data-role="button" data-icon="check" rel="external">Sign out</a>
				<a href="/words/add" data-role="button" data-icon="plus">add</a>
				<a href="/message/" data-role="button" data-icon="star">message</a>
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
					<c:forEach var="e" items="${wordList}">
					<li><a href="/words/imet/${e.id}">
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
			<div class="wordsyoucomment">
				<p>${f:h(user.nickname)}さんが残したコメント</p>
				<ul data-role="listview" data-filter="true">
					<li><a href="/words/icomment/xyz">
						<h3>そんなときもあるよね。でも大丈夫。何も心配いらない。すべてうまくいくよ。</h3>
					</a></li>
					<li><a href="/words/icomment/brahbrah">
						<h3>もっと力を抜いて行こう！</h3>
					</a></li>
					<c:forEach var="e" items="${commentList}">
					<li><a href="/words/icomment/${f:url(e.id)}">
						<h3>${f:h(e.comment)}</h3>
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
