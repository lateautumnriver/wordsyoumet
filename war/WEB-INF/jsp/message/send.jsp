<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="wym" tagdir="/WEB-INF/tags/layout"%>
<wym:loggedin title="${title}">
	<div data-role="page" data-theme="${f:h(theme)}">
		<header data-role="header" data-theme="${f:h(theme_header)}">
			<h1>メッセージ送信</h1>
			<div data-role="controlgroup" data-type="horizontal" class="control">
				<a href="${signoutURL}" data-role="button" data-icon="check" rel="external">Sign out</a>
				<a href="/words/imet/${f:h(word.id)}" data-role="button" data-icon="back">back</a>
				<%--
				<a href="/account/" data-role="button" data-icon="gear">account</a>
				--%>
			</div>
		</header>
		<div data-role="content">
			<div id="new-message-form-div">
				<c:if test="${! empty error}">
				<div class="error">
					<p>${f:h(error)}</p>
				</div>
				</c:if>
				<form action="/message/send" method="POST">
				<div data-role="fieldcontain">
					<fieldset data-role="controlgroup">
						<legend>メッセージ</legend>
						<label for="message-to" class="select">宛先<span class="fyi">（必須）</span></label>
						<select id="message-to-id" name="message-to" required="required">
							<c:forEach var="nickname" items="${friendList}">
							<option value="${f:h(nickname)}">${f:h(nickname)}</option>
							</c:forEach>
						</select>
						<label for="message-body">あなたからのメッセージ<span class="fyi">（必須）</span></label>
						<textarea id="message-body" name="message-body" rows="10" style="height:10em;" required="required"></textarea>
					</fieldset>
					
			<%-- TODO テンプレートにする --%>
			<%-- ことばの詳細テンプレート --%>
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
			<%-- TODO テンプレートにする --%>

					<fieldset class="ui-grid-a">
						<div class="ui-block-a"><input type="submit" id="message-send-trigger" value="送る" data-mini="true" /></div>
						<div class="ui-block-b"><input type="button" id="message-cancel-trigger" value="キャンセル" data-mini="true" onclick="$(location).attr('href', '/words/imet/${f:h(word.id)}')" /></div>
					</fieldset>
					<input type="hidden" name="wordid" value="${f:h(word.id)}" />
				</div>
				</form>
			</div>
		</div>
		<%--
		<footer data-role="footer">
			<a href="/words/imet" data-role="button" data-mini="true" data-inline="true" data-icon="back">back</a>
		</footer>
		--%>
	</div>
</wym:loggedin>
