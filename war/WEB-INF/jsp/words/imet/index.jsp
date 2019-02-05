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
				<a href="/words/imet" data-role="button" data-icon="back">back</a>
				<a href="/words/add" data-role="button" data-icon="plus">add</a>
				<a href="/words/imet/delete/${f:h(word.id)}" data-role="button" data-icon="delete">delete</a>
				<%--
				<a href="/account/" data-role="button" data-icon="gear">account</a>
				--%>
			</div>
		</header>
		<div data-role="content">
			<div class="wordsyoumet">
				<artile id="${f:h(word.id)}">
					<h1><q>${f:h(word.word)}</q></h1>
					<div class="author">
						<span class="author">${f:h(word.author)}</span>
						<c:if test="${! empty word.cite}"><cite>${f:h(word.cite)}</cite></c:if>
					</div>
					<c:if test="${! empty word.desc}"><p class="desc">${f:h(word.desc)}</p></c:if>
				</artile>
			</div>
			<div class="function">
				<fieldset class="ui-grid-a">
					<div id="send-message-button" class="ui-block-a"><a href="/message/send/${f:h(word.id)}" data-role="button" data-ajax="false">メッセージを送る</a></div>
				</fieldset>
			</div>
			<%-- TODO コメントリストを実装、表示する --%>
			<c:if test="${! empty commentList}">
			<div class="comment">
				<p>コメント</p>
				<ul data-role="listview" data-filter="true">
					<c:forEach var="e" items="${commentList}">
					<li><a href="/words/comment/${f:url(word.id)}">
						<h3>${f:h(e.comment)}</h3>
					</a></li>
					</c:forEach>
				</ul>
			</div>
			</c:if>
		</div>
		<%--
		<footer data-role="footer">
			<a href="/words/imet" data-role="button" data-mini="true" data-inline="true" data-icon="back">back</a>
		</footer>
		--%>
	</div>
</wym:loggedin>
