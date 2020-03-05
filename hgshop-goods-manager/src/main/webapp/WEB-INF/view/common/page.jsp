<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<nav aria-label="Page navigation example">
 		 <ul class="pagination pagination-sm">
  			<c:forEach begin="${info.pageNum-2>1?info.pageNum-2:1}" end="${info.pageNum+2<info.pages?info.pageNum+2:info.pages}"  varStatus="index">
  			
  			<li class="page-item"  
  			>  
  			  <button type="button" <c:if test="${info.pageNum==index.index }">style="color:red;"</c:if> onclick="page(${index.index})">${index.index}</button></li>
  			</c:forEach>
  
 		 </ul>
		</nav>