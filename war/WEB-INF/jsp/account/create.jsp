<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="wym" tagdir="/WEB-INF/tags/layout"%>
<wym:loggedin title="${title}">
	<div data-role="page" data-theme="${f:h(theme)}">
		<header data-role="header" data-theme="${f:h(theme_header)}">
			<h1>${f:h(title)}</h1>
			<div class="account"><p>${f:h(userName)}</p></div>
			<div data-role="controlgroup">
				<a href="${signoutURL}" data-role="button" data-icon="check" rel="external">Sign out</a>
			</div>
		</header>
		<div data-role="content">
			<div class="lead">
				<p>Input your account data.</p>
			</div>
			<c:if test="${! empty message}">
			<div class="warn">
				<p>${f:h(message)}</p>
			</div>
			</c:if>
			<div id="account-create">
				<form action="/account/create" method="POST" data-ajax="false">
					<fieldset data-role="fieldcontain" class="ui-hide-label">
						<label for="account-nickname">nickname</label>
						<input type="text" id="account-nickname" name="account-nickname" value="${f:h(nickname)}" placeholder="nickname" data-mini="true" />
						<input type="submit" value="OK" data-mini="true" />
					</fieldset>
				</form>
			</div>
		</div>
		<footer data-role="footer">
		</footer>
	</div>
</wym:loggedin>
