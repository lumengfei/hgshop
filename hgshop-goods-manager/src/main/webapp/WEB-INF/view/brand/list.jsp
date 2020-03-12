<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	 <input id="first" value="${first}"/>
	<button type="button" class="btn btn-primary" onclick="query()">
   	查询 </button>   	
   
   	
 	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
   	添加 </button> 
   	
   	
   	
</div>


<table class="table">
  <tr>
    <th>id</th>
    <th>品牌</th>
    <th>品牌首字母</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${info.list}" var="brand">
  	<tr>
    <td>${brand.id}</td>
    <td>${brand.name}</td>
    <td>${brand.firstChar}</td>
    <td>
    	<button type="button" class="btn btn-danger" onclick="delBrand(${brand.id})">删除</button>
				<button type="button" class="btn btn-warning" onclick="openUpdateBrand(${brand.id})">修改</button>
    </td>
  </tr>
  </c:forEach>
  <tr>
  	<th colspan="3"><center>
		<jsp:include page="../common/page.jsp"></jsp:include>
		</center>
  	</th>
  </tr>
</table>



<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加品牌</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="addBrand">
        		 <div class="form-group">
    				<label for="specName">品牌名称</label>
    				<input type="text" class="form-control" name="name" id="name" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入品牌名称</small>
  				</div>
  				<div class="form-group">
    				<label for="inputAddress">品牌首字母</label>
    				<input type="text" name="firstChar" class="form-control" id="inputAddress" placeholder="品牌首字母">
    				<!-- <button onclick="$(this).parent().remove()">删除</buttonn> -->
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="commitBrand()">提交</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="staticBackdropUp" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropUpLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropUpLabel">添加品牌</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="updateBrand"><input type="hidden" name="id" id="upId">
        		 <div class="form-group">
    				<label for="specName">品牌名称</label>
    				<input type="text" class="form-control" name="name" id="upName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入品牌名称</small>
  				</div>
  				<div class="form-group">
    				<label for="inputAddress">品牌首字母</label>
    				<input type="text" name="firstChar" class="form-control" id="upFirstChar" placeholder="品牌首字母">
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="updateBrand()">提交</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	/*
		添加品牌
	*/
	function commitBrand(){
		var data =$("#addBrand").serialize();
		$.post("/brand/add",data,function(obj){
			if(obj.data==1){
				alert(obj.msg)
				$("#staticBackdrop").modal('hide')
			}else{
				alert(obj.error)
			}
		},"json")
	}

	/*
		弹出模态框 回显修改数据
	*/
	function openUpdateBrand(id){
		$.post("/brand/getBrand",{id:id},function(obj){
				$("#upId").val(obj.id)
				$("#upName").val(obj.name)
				$("#upFirstChar").val(obj.firstChar)
			
		},"json")
		
		
		$("#staticBackdropUp").modal('show')
	}


	/*
		修改品牌
	*/
	function updateBrand(){
		var data =$("#updateBrand").serialize();
		$.post("/brand/update",data,function(obj){
			if(obj.data==1){
				alert(obj.msg)
				$("#staticBackdropUp").modal('hide')
			}else{
				alert(obj.error)
			}
		},"json")
	}


	/*
		删除品牌
	*/
	function delBrand(id){
		$.post("/brand/delBrand",{id:id},function(obj){
			if(obj.data==1){
				alert(obj.msg)
				refresh();
			}else{
				alert(obj.error)
			}
		
	},"json")
	}
	
	/*
		根据品牌首字母查询
	*/
	 function query(){
		var first= $("#first").val();
		 
		 var url="/brand/list?first="+first;
			$("#main").load(url);
	} 


	// 给模态框增加关闭以后的事件  
	$('#staticBackdrop').on('hidden.bs.modal', function (e) {
	 	 // do something...
		refresh();
	})
	
	// 给模态框增加关闭以后的事件  
	$('#staticBackdropUp').on('hidden.bs.modal', function (e) {
	 	 // do something...
		refresh();
	})

	/**
	* 刷新 而且保持查询条件和页码
	*/
	function refresh(){
		var url="/brand/list?first="+$("#first").val()+"&page="+${info.pageNum};
		$("#main").load(url);
	}
	
	
	
/*
进行分页查询加规格名称查询
*/
function page(page){
var url="brand/list?first="+$("#first").val()+"&page="+page;
$("#main").load(url);
}
</script>

