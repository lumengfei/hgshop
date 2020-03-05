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


<!-- Modal -->
<div class="modal fade" id="staticBackdropUpdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropUpdateLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">修改规格</h5>
         <button type="button" onclick="updProp()"> 添加属性
         </button>
         
       			 
         
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="updspec">
        			<input type="hidden" name="id" id="upId">
        		 <div class="form-group">
    				<label for="specName">规格名称</label>
    				<input type="text" class="form-control" name="specName" id="upSpecName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入规格名称</small>
  				</div>
  				<!-- <div class="form-group">
    				<label for="inputAddress">属性值</label>
    				<input type="text" name="options[0].optionName" class="form-control" id="upInputAddress" placeholder="1234 Main St">
    				<button onclick="$(this).parent().remove()">删除</buttonn>
  				</div> -->
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="upCommitSpec()">修改提交</button>
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
  	<th colspan="3"><center>
		<jsp:include page="../common/page.jsp"></jsp:include>
		</center>
  	</th>
  </tr>
</table>
 
  
 <script type="text/javascript">
	var addindex=1;
	
	var updindex=0;
	
	function openUpdateSpec(id){
		$.post("/spec/getSpec",{id:id},function(obj){
			alert(obj)
			$("#upId").val(obj.id)
			$("#upSpecName").val(obj.specName)
			for(var i in obj.options){
				$("#updspec").append('<div class="form-group">'+
	    				'<label for="inputAddress">属性值</label>'+
	    				'<input type="text" name="options['+updindex+'].optionName"  value="'+obj.options[i].optionName+'" class="form-control" id="upInputAddress" placeholder="1234 Main St">'+
	    				'<button onclick="$(this).parent().remove()">删除</button>'+
	    				'</div>')
	    	updindex++;
			}
		},"json")
		
		
		//弹出模态框
		$("#staticBackdropUpdate").modal('show')
	}
	
	
	/*
	添加修改属性框
	*/
	function updProp(){
		$("#updspec").append('<div class="form-group">'+
				'<label for="inputAddress">属性值</label>'+
				'<input type="text" name="options['+updindex+'].optionName"  class="form-control" id="upInputAddress" placeholder="1234 Main St">'+
				'<button onclick="$(this).parent().remove()">删除</button>'+
				'</div>')
		updindex++;
	} 
	
	
	/**
	  提交修改数据	
	*/
	function upCommitSpec(){
		
		//addspec
		 var data =$("#updspec").serialize(); 
		 
		/*  var data = new FormData($("#addspec")[0]);  */
		 
		$.post("/spec/updateSpec",data,function(obj){
			if(obj.data==1){
				alert(obj.msg)
				 $('#staticBackdropUpdate').modal('hide')
				 
			}else{
				alert(obj.error)
			}
		},"json")  
	}
	
	
	
	
	
	
	
	
	
	/*
		添加属性框
	*/
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
	
	// 给模态框增加显示成成功后的事件  
	$('#staticBackdropUpdate').on('shown.bs.modal', function (e) {
		  // do something...
		resetAddForm();
	})
	
	// 给模态框增加关闭以后的事件  
	$('#staticBackdropUpdate').on('hidden.bs.modal', function (e) {
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
	
	
	
	
	/**
	* 修改一个checkbox
	*/
	function  selectedOne(){
		// 判断是否所有的都被选中了
		var allSelectd = $("[name=ids]:checked").length==$("[name=ids]").length;
		
		//设置全选的框
		$("#allSel").prop("checked",allSelectd);
		
	}
	
	
	/*
		根据Id删除一条数据delSec
	*/
	function delSec(id){
		if(window.confirm("是否删除id为"+id+"的规格")){
			$.post("spec/delSpec",{id:id},function(obj){
				if(obj.data==1){
					alert(obj.msg)
					refresh();
				}else{
					alert(obj.error)
				}
			},"json")
		}
		return ;
	}
	
	/*
		根据选中的数据进行批量删除
	*/
	function delBatch(){
		if($("[name=ids]:checked").length<=0){
			alert("请选择您要删除的数据")
			return ;
		}
		// 组织删除的数据
		var delIds  = new Array();
		$("[name=ids]:checked").each(function(){
			delIds.push($(this).val());
		})
		
		
		if(confirm("您确认删除这些数据么？")){
			$.post("/spec/delSpecBatch",{ids:delIds},function(obj){
				if(obj.data==1){
					alert(obj.msg)
					refresh();
				}else{
					alert(obj.error)
				}
				
			});
		}else{
			return;
		}
	}
 </script>