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
				<%--
				<a href="/account/" data-role="button" data-icon="gear">account</a>
				--%>
			</div>
		</header>
		<div data-role="content">
			<c:if test="${! empty message}">
			<div class="warn">
				<p>${f:h(message)}</p>
			</div>
			</c:if>
			<div id="new-word-add">
				<form action="/words/add" method="POST" data-ajax="false">
				<div data-role="fieldcontain"<%-- class="ui-hide-label" --%>>
					<fieldset data-role="controlgroup">
						<label for="new-word">出会ったことば<span class="fyi">（必須）</span></label>
						<textarea id="new-word" name="new-word" placeholder="ことば" required="required" autofocus="autofocus">${f:h(word)}</textarea>

						<label for="new-word-author">言った人<span class="fyi">（必須）</span></label>
						<input type="text" id="new-word-author" name="new-word-author" value="${f:h(author)}" placeholder="だれ" required="required" />

<%--
						<label for="new-word-date">出会ったとき<span class="fyi"></span></label>
						<input type="date" id="new-word-date" name="new-word-date" value="${f:h(date)}" placeholder="いつ" min="2012-06-12" />
--%>
						<label for="new-word-cite">引用元<span class="fyi"></span></label>
						<input type="text" id="new-word-cite" name="new-word-cite" value="${f:h(cite)}" placeholder="" />

						<label for="new-word-desc">ものがたり<span class="fyi"></span></label>
						<textarea id="new-word-desc" name="new-word-desc" placeholder="このことばにまつわるものがたり">${f:h(desc)}</textarea>

						<label for="new-word-note">ノート<span class="fyi">（公開されません）</span></label>
						<textarea id="new-word-note" name="new-word-note" placeholder="なんでも">${f:h(note)}</textarea>

					</fieldset>
					<fieldset class="buttons" data-role="controlgroup" data-type="horizontal">
					  <label for="new-word-tweet">tweet</label>
					  <input type="checkbox" id="new-word-tweet" name="new-word-tweet" checked="checked" class="custom" data-mini="true" />

					  <label for="new-word-facebook">FB</label>
					  <input type="checkbox" id="new-word-facebook" name="new-word-facebook" checked="checked" class="custom" data-mini="true" />
					</fieldset>

					<input type="submit" value="追加" />
				</div>
				</form>
			</div>
		</div>
		<!-- include footer -->
	</div>
</wym:loggedin>
