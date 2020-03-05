<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<input id="queryName" value="${queryName}"/>
	<button type="button" class="btn btn-primary" onclick="query()">
   	查询 </button>
   	
   	<button type="button" class="btn btn-primary" onclick="delBatch()">
   	批量删除</button>
   	
   	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
   	添加 </button>
   	
   	
   	
</div>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
         <button type="button" onclick="addProp()"> 添加属性
         </button>
         
       			 
         
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="addspec">
        		 <div class="form-group">
    				<label for="specName">规格名称</label>
    				<input type="text" class="form-control" name="specName" id="specName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入规格名称</small>
  				</div>
  				<div class="form-group">
    				<label for="inputAddress">属性值</label>
    				<input type="text" name="options[0].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">
    				<button onclick="$(this).parent().remove()">删除</buttonn>
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="commitSpec()">提交</button>
      </div>
    </div>
  </div>
</div>

  
  
<table class="table">
  <tr>
    <th>id <input type="checkbox" id="allSel" onchange="selectedAll()">  
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(1)">全选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(2)">全不选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(3)">反选</button>
		 </th>
    <th>名称</th>
    <th>详情</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${info.list}" var="spec">
  	<tr>
    <td><input type="checkbox" name="ids" value="${spec.id}" onchange="selectedOne()">${spec.id }</td>
    <td>${spec.specName }</td>
    <td>
    	<c:forEach items="${spec.options }" var="option">
    	&emsp;${option.optionName }
    	</c:forEach>
    </td>
    <td>
    	<button type="button" class="btn btn-danger" onclick="delSec(${spec.id})">删除</button>
				<button type="button" class="btn btn-warning" onclick="openUpdateSpec(${spec.id})">修改</button>
    </td>
  </tr>
  </c:forEach>
  <tr>
  	<th colspan="3">
		<jsp:include page="../common/page.jsp"></jsp:include>
  	</th>
  </tr>
</table>
 
  
 <script type="text/javascript">
	var addindex=1;
	function addProp(){
		$("#addspec").append('<div class="form-group">'+
    				'<label for="inputAddress">属性值</label>'+
    				'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">'+
    				'<button onclick="$(this).parent().remove()">删除</button>'+
    				'</div>')
    	addindex++;
	} 
	
	
	/**
	  提交数据	
	*/
	function commitSpec(){
		
		//addspec
		 var data =$("#addspec").serialize(); 
		 
		/*  var data = new FormData($("#addspec")[0]);  */
		  alert(data)
		$.post("/spec/add",data,function(obj){
			if(obj.data==1){
				alert(obj.msg)
				 $('#staticBackdrop').modal('hide')
				 
			}else{
				alert(obj.error)
			}
		},"json")  
	}
	
	// 给模态框增加显示成成功后的事件  
	$('#staticBackdrop').on('shown.bs.modal', function (e) {
		  // do something...
		resetAddForm();
	})
	
	// 给模态框增加关闭以后的事件  
	$('#staticBackdrop').on('hidden.bs.modal', function (e) {
		  // do something...
		refresh();
	})
	
	//添加窗口的复位
	function resetAddForm(){
		$(".form-group-proper").each(function(){
			$(this).remove();
		})
		addindex=1;
		$("#specName").val("")
		
	}
	
	/**
	* 刷新 而且保持查询条件和页码
	*/
	function refresh(){
		
		var url="/spec/list?name=${queryName}"+'&page=${pageInfo.pageNum}';
		$("#main").load(url);
	}
	
	/*
		进行规格名称查询
	*/
	function query(){
		var url="spec/list?name="+$("#queryName").val();
		$("#main").load(url);
	}
	/*
		进行分页查询加规格名称查询
	*/
	function page(page){
		var url="spec/list?name="+$("#queryName").val()+"&page="+page;
		$("#main").load(url);
	}
	
	
	/**
	点击三个按钮
	*/
	function selAll(flag){
		
	 	if(flag==1){
			//全选
			$("[name=ids]").each(function(){
				$(this).prop("checked",true)
			}
			)
		}
		
		if(flag==2){
			//全不选
			$("[name=ids]").each(function(){
				$(this).prop("checked",false)
			})
		}
		if(flag==3){
			//反选
			$("[name=ids]").each(function(){
				var ch = !$(this).prop("checked")
				$(this).prop("checked",ch)
			}
			)
		} 
		// 判断是否所有的都被选中了
		var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
		//设置全选的框
		$("#allSel").prop("checked",allSelected)
		
	}
	
	
	
	
	
	function  selectedOne(){
		
	}
	
	
	
 </script>