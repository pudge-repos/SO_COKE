define(['jquery', 'knockout' ], function($, ko) {
     var ctrl = {};
     /**
      * 按钮
      */
	ctrl.headButtongroups = [];
	/**
	 * 界面初始化
	 */
	ctrl.init = function(viewModel,viewModelManager){
		
	}
	/**
	 * 界面初始化后
	 */
	ctrl.afterInit = function(viewModel,viewModelManager){
		
	}
	/**
	 * 视图模型初始化之后
	 */
	ctrl.onViewModelInit = function(viewModel,manager){
		$.removeWaiting(); 
	}
	/**
	 * 获取数据加载URL
	 */
	ctrl.getDatasetLoaderURL = function(params){
		console.log('params:',params);
		return "/iwebap/psndoc/1001381000000000008E"
	}
	/**
	 * 提交表单
	 */
	ctrl.onSubmitForm = function(){
		
	}
	/**
	 * 数据获取事件
	 */
	ctrl.onDataload = function(viewModel,manager){
		
	}
	/**
	 * 取消提交
	 */
	ctrl.cancelSubmit = function(){
		
	}
    return ctrl;
});