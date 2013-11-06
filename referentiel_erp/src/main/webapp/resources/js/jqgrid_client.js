var jq = jQuery.noConflict();
jq(function() {
	jq("#grid").jqGrid(
			{
				url : './taches/manage',
				datatype : 'json',
				mtype : 'GET',
				colNames : [ 'ID', 'Client', 'Description', 'Adresse', 'Secteur'],
				colModel : [ {
					name : 'id',
					index : 'id',
					width : 55,
					align : "center",
					editable : false,
					editoptions : {
						readonly : true,
						size : 10
					},
					hidden : true
				},
				{
					name : 'client',
					index : 'client',
					width : 100,
					align : "center",
					sortable : false,
					editable : true,
					editable : true,
					editrules : {
						required : true
					},
					edittype: 'text'

				},
				{
					name : 'description',
					index : 'description',
					width : 100,
					align : "center",
					sortable : false,
					editable : true,
					editable : true,
					editrules : {
						required : true
					},
					edittype: 'text'
				}, {
					name : 'adresse',
					index : 'adresse',
					width : 100,
					align : "center",
					sortable : false,
					editable : true,
					editable : true,
					editrules : {
						required : true
					},
	            	 edittype: 'text'

				},{
					name : 'secteur',
					index : 'secteur',
					width : 100,
					align : "center",
					sortable : false,
					editable : true,
					editable : true,
					editrules : {
						required : true
					},
	            	 edittype: 'text'

				} ],
				postData : {},
				rowNum : 20,
				rowList : [ 20, 40, 60 ],
				height : 200,
				autowidth : true,
				rownumbers : true,
				pager : '#pager',
				sortname : 'id',
				viewrecords : true,
				sortorder : "asc",
				caption : "Taches",
				emptyrecords : "Empty records",
				loadonce : false,
				ajaxGridOptions : {
					contentType : "application/json"
				},
				ajaxCellOptions : {
					contentType : "application/json"
				},
				ajaxRowOptions : {
					contentType : "application/json"
				},
				ajaxDelOptions: {
					contentType: "application/json"
				},
				ajaxEditOptions: {
					contentType: "application/json"
				},
				loadComplete : function() {
				},
				jsonReader : {
					root : "rows",
					page : "page",
					total : "total",
					records : "records",
					repeatitems : false,
					cell : "cell",
					id : "id"
				}
			});
	jq("#grid").jqGrid('navGrid', '#pager', {
		edit : false,
		add : false,
		del : false,
		search : false
	});

	jq("#grid").navButtonAdd('#pager', {
		caption : "Add",
		buttonicon : "ui-icon-plus",
		onClickButton : addRow,
		position : "last",
		title : "",
		cursor : "pointer"
	});

	jq("#grid").navButtonAdd('#pager', {
		caption : "Edit",
		buttonicon : "ui-icon-pencil",
		onClickButton : editRow,
		position : "last",
		title : "",
		cursor : "pointer"
	});

	jq("#grid").navButtonAdd('#pager', {
		caption : "Delete",
		buttonicon : "ui-icon-trash",
		onClickButton : deleteRow,
		position : "last",
		title : "",
		cursor : "pointer"
	});

});

function addRow() {

	// Get the currently selected row
	jq("#grid").jqGrid('editGridRow', 'new', {
		url : "./clients/add",
		editData : {},
		recreateForm : true,
		mtype: 'PUT',
		ajaxEditOptions:{ contentType:"application/json" },
		beforeShowForm : function(form) {
		},
		closeAfterAdd : true,
		reloadAfterSubmit : true,
		serializeEditData:function (data) {
			delete data.oper;
			delete data.id;

			//Opérations sur la date
			var date = data.date.split('.');
			data.year = date[0];
			data.month = date[1];
			data.day = date[2];
			delete data.date;

			//Opérations sur le projet
			var proj = data.projet.replace('>','.');
			proj = proj.replace('<','.');
			proj = proj.split('.');
			data.projetId = proj[0];
			delete data.projet;

			return JSON.stringify(data);
		},
		afterSubmit : function(response, postdata) {
			var result = eval('(' + response.responseText + ')');
			var errors = "";

			if (result.success == false) {
				for ( var i = 0; i < result.message.length; i++) {
					errors += result.message[i] + "";
				}
			} else {
				jq("#dialog").text('Entry has been added successfully');
				jq("#dialog").dialog({
					title : 'Success',
					modal : true,
					buttons : {
						"Ok" : function() {
							jq(this).dialog("close");
						}
					}
				});
			}
			new_id = result.newId;
			return [ result.success, errors, new_id ];
		}
	});

}


function editRow() {
	// Get the currently selected row
	var row = jq("#grid").jqGrid('getGridParam', 'selrow');

	if (row != null)
		jq("#grid").jqGrid('editGridRow', row, {
			url : "./clients/edit",
			editData : {},
			recreateForm : true,
			mtype : 'POST',
			ajaxEditOptions:{ contentType:"application/json" },
			beforeShowForm : function(form) {
			},
			serializeEditData:function (data) {
				delete data.oper;

				//Opérations sur la date
				var date = data.date.split('.');
				data.year = date[0];
				data.month = date[1];
				data.day = date[2];
				delete data.date;

				//Opérations sur le projet
				var proj = data.projet.replace('>','.');
				proj = proj.replace('<','.');
				proj = proj.split('.');
				data.projetId = proj[0];
				delete data.projet;

				return JSON.stringify(data);
			},
			closeAfterEdit : true,
			reloadAfterSubmit : false,
			afterSubmit : function(response, postdata) {
				var result = eval('(' + response.responseText + ')');
				var errors = "";

				if (result.success == false) {
					for ( var i = 0; i < result.message.length; i++) {
						errors += result.message[i] + "";
					}
				} else {
					jq("#dialog").text('Entry has been edited successfully');
					jq("#dialog").dialog({
						title : 'Success',
						modal : true,
						buttons : {
							"Ok" : function() {
								jq(this).dialog("close");
							}
						}
					});
				}

				return [ result.success, errors, null ];
			}
		});
	else
		jq("#dialogSelectRow").dialog();
}

function deleteRow() {
	// Get the currently selected row
	var row = jq("#grid").jqGrid('getGridParam', 'selrow');

	// A pop-up dialog will appear to confirm the selected action
	if (row != null)
		jq("#grid").jqGrid(
				'delGridRow',
				row,
				{
					url : './clients/delete',
					editData : {},
					mtype: 'DELETE',
					ajaxEditOptions:{ contentType:"application/json" },
					recreateForm : true,
					beforeShowForm : function(form) {
					},
					serializeDelData:function (data) {

						delete data.date;
						delete data.projet;
						delete data.fini;
						return JSON.stringify(data);
					},
					reloadAfterSubmit : false,
					closeAfterDelete : true,
					afterSubmit : function(response, postdata) {
						var result = eval('(' + response.responseText + ')');
						var errors = "";

						if (result.success == false) {
							for ( var i = 0; i < result.message.length; i++) {
								errors += result.message[i] + "";
							}
						} else {
							jq("#dialog").text(
							'Entry has been deleted successfully');
							jq("#dialog").dialog({
								title : 'Success',
								modal : true,
								buttons : {
									"Ok" : function() {
										jq(this).dialog("close");
									}
								}
							});
						}
						return [ result.success, errors, null ];
					}
				});
	else
		jq("#dialogSelectRow").dialog();
}
