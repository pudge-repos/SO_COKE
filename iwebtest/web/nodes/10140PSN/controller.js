define(['jquery', 'knockout', '/iwebap/js/idHelper.js'], function($, ko, idHelper) {
	var ctrl = {};
	/**
	 * 按钮
	 */
	ctrl.headButtongroups = [];
	/**
	 * 界面初始化
	 */
	ctrl.init = function(viewModel, viewModelManager) {
		 this.viewModel = viewModel;
		 this.vmManager = viewModelManager;
	}
		/**
		 * 界面初始化后
		 */
	ctrl.afterInit = function(context,viewModel) {
			var model = viewModel.aggDs;
			model.head.getField("id").on("change", function(val) {
				if (model.bindHeadPk('idtype')() == "1001Z01000000000AI36") {
					var idCode = val.newValue;
					var isValidId = idHelper.check(idCode)
					if (isValidId) {
						var sex = idHelper.getSex(idCode);
						model.bindHeadPk('sex')(sex)
						var birthdate = idHelper.getBirthdate(idCode);
						model.bindHeadPk('birthdate')(birthdate)
					}
				}
			})
			/**
			 * 设置公共的组织编码获取方法.部分参照需要通过组织过滤
			 */
			window.getPKOrg = function(){
				return model.bindHeadPk('pk_org')();
			}
	}
		/**
		 * 视图模型初始化之后
		 */
	ctrl.onViewModelInit = function(viewModel, manager) {

		}
		/**
		 * 获取数据加载URL
		 */
	ctrl.getDatasetLoaderURL = function(params) {
		
		}
		/**
		 * 提交表单
		 */
	ctrl.onSubmitForm = function() {
			$.showWaiting(); 
 			var param = window.context.parameters; 
			var funNode = window.context.environment["busino"];
			param.bill = ko.toJSON(this.aggDs.getAggDatas()); 
			ctrl.vmManager.ajax({ 
				type: "POST", 
				url: "/iwebap/psndoc", 
				data:param, 
				dataType: "json" ,
				success: function(result) {
					$.removeWaiting(); 
					//document.location.href='/iwebap/nodeurl/Finder?templateType=0&funNode=' + funNode+ '&nodeKey=psndoc&pageTemplate=noworkflowview.html'
		        }
			});
			
		}
		/**
		 * 数据获取事件
		 */
	ctrl.onDataload = function(viewModel, manager) {

		}
		/**
		 * 取消提交
		 */
	ctrl.cancelSubmit = function() {
		
	}




	return ctrl;
});