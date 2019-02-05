<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@attribute name="title" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8" />
	<title>Words You Met: ${f:h(title)}</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/themes/encourage.min.css" />
	<link rel="stylesheet" href="/css/jquery.mobile.structure-1.1.0.min.css" />
	<link rel="stylesheet" href="/css/wordsyoumet.css" />
	<script src="/js/jquery-1.7.1.min.js"></script>
	<script src="/js/jquery.mobile-1.1.0.min.js"></script>
</head>
<body>
<jsp:doBody/>
</body>
</html>
