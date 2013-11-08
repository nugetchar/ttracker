var jq = jQuery.noConflict();
var d =  new Date(), n = d.getMonth() + 1, y = d.getFullYear();
jq(function() {
	jq("#grid").jqGrid(
			{
				url : './imputations/timesheet/' + n + '/' + y,
				datatype : "json",
				mtype : "GET",
				colNames : [ "Projet", "Tache", "1", "2", "3", "4", "5", "6",
				             "7", "8", "9", "10", "11", "12", "13", "14", "15",
				             "16", "17", "18", "19", "20", "21", "22", "23", "24",
				             "25", "26", "27", "28", "29", "30", "31" ],
				             colModel : [ {
				            	 name : "projet",
				            	 index : "projet",
				            	 width : 120,
				            	 align : "center",
				            	 edittype : "select",
				            	 editable : false,
				            	 editoptions : {
				            		 size : 1,
				            		 dataUrl : './projets/affectes'
				            	 },
				            	 sortable : true
				             }, {
				            	 name : "tache",
				            	 index : "tache",
				            	 width : 130,
				            	 align : "center",
				            	 edittype : "select",
				            	 editable : false,
				            	 editoptions : {
				            		 size : 1,
				            		 dataUrl : './taches/tachesNonFinies'
				            	 },
				            	 sortable : true
				             }, {
				            	 name : "1",
				            	 index : "1",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 edittype : "select",
				            	 editable : true,
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "2",
				            	 index : "2",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "3",
				            	 index : "3",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "4",
				            	 index : "4",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "5",
				            	 index : "5",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "6",
				            	 index : "6",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "7",
				            	 index : "7",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "8",
				            	 index : "8",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "9",
				            	 index : "9",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "10",
				            	 index : "10",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "11",
				            	 index : "11",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "12",
				            	 index : "12",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "13",
				            	 index : "13",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "14",
				            	 index : "14",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "15",
				            	 index : "15",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "16",
				            	 index : "16",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "17",
				            	 index : "17",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "18",
				            	 index : "18",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "19",
				            	 index : "19",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "20",
				            	 index : "20",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "21",
				            	 index : "21",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "22",
				            	 index : "22",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "23",
				            	 index : "23",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "24",
				            	 index : "24",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "25",
				            	 index : "25",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "26",
				            	 index : "26",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "27",
				            	 index : "27",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "28",
				            	 index : "28",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "29",
				            	 index : "29",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "30",
				            	 index : "30",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }, {
				            	 name : "31",
				            	 index : "31",
				            	 width : 20,
				            	 align : "center",
				            	 sortable : false,
				            	 editable : true,
				            	 edittype : "select",
				            	 editoptions : {
				            		 value : "1:1; 0.5:0.5; 0.25:0.25; 0:0",
				            		 defaultValue : "0"
				            	 }
				             }

				             ],
				             postData : {},
				             rowNum : 20,
				             rowList : [ 20, 40, 60 ],
				             height : 200,
				             autowidth : true,
				             cellEdit : true,
				             cellsubmit : 'clientArray',
				             rownumbers : true,
				             pager : '#pager',
				             sortname : 'projet,tache',
				             viewrecords : true,
				             sortorder : "asc",
				             caption : "Timesheet",
				             autoencode : false,
				             gridview : true,
				             emptyrecords : "Vous n'avez pas d'imputation pour ce mois",
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
				             ajaxDelOptions : {
				            	 contentType : "application/json"
				             },
				             ajaxEditOptions : {
				            	 contentType : "application/json"
				             },
				             beforeSubmitCell : function(rowid, celname, value, iRow, iCol) {
				            	 selectedRowId = jq('#grid')
				            	 .jqGrid('getGridParam', 'selrow');
				            	 tache = jq('#grid').jqGrid('getCell', selectedRowId,
				            	 'tache');
				            	 projet = jq('#grid').jqGrid('getCell', selectedRowId,
				            	 'projet');
				            	 v = JSON.stringify({
				            		 valeur : value,
				            		 nom_cellule : celname,
				            		 tache : tache,
				            		 projet : projet,
				            		 month : n + "",
				            		 year : y + ""
				            	 });
				            	 send(v);
				            	 return v;
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
	//#############################################################################

	/*Création du groupHeader pour le mois courant*/
	//#############################################################################
	jq("#grid").jqGrid("setGroupHeaders", {
		useColSpanStyle : true,
		groupHeaders : [ {
			startColumnName : "1",
			numberOfColumns : 31,
			titleText : "<em>" + getLibMonth(n) + " - " + y + "</em>"
		} ]
	});
	//#############################################################################

	/* Customisation des boutons du pager */
	//#############################################################################

	jq('#grid').navGrid('#pager', {
		search : false,
		edit : false,
		add : false,
		del : false
	}, {}, {}, {}, {
		closeOnEscape : false,
		multipleSearch : false,
		closeAfterSearch : false
	});
	//#############################################################################

	/* Bouton "Mois précédent" */
	//#############################################################################
	jq('#grid').jqGrid(
			'navButtonAdd',
			"#pager",
			{
				caption : "Mois precedent",
				buttonicon : "ui-icon-circle-arrow-w",
				onClickButton : function() {
					n--;
					if(n<1){
						n = 12;
						y--;
					}
					var newUrl = './imputations/timesheet/' + n + '/' + y;
					jq("#grid").setGridParam({
						url : newUrl
					});
					jq("#grid").trigger("reloadGrid");
					updateMonth();

				},
				position : "last",
				title : "Previous month",
				cursor : "pointer"
			});
	//#############################################################################

	/*Bouton "Mois suivant"*/
	//#############################################################################
	jq('#grid').jqGrid(
			'navButtonAdd',
			"#pager",
			{
				caption : "Mois suivant",
				buttonicon : "ui-icon-circle-arrow-e",
				onClickButton : function() {
					if ((y < d.getFullYear()) || ((y == d.getFullYear()) && (n <= d.getMonth()))) {
						n++;
						if(n>12){
							n = 1;
							y++;
						}
						var newUrl ='./imputations/timesheet/' + n + '/' + y;
						jq("#grid").setGridParam({
							url : newUrl
						});
						jq("#grid").trigger("reloadGrid");
						updateMonth();
					}
				},
				position : "last",
				title : "Next month",
				cursor : "pointer"
			});
	//#############################################################################


	/**
	 * Fonctions de service
	 */

	/**
	 * Retourne le libellé du mois correspondant
	 */
	function getLibMonth(number) {
		if (number == 1)
			return "Janvier";
		if (number == 2)
			return "Février";
		if (number == 3)
			return "Mars";
		if (number == 4)
			return "Avril";
		if (number == 5)
			return "Mai";
		if (number == 6)
			return "Juin";
		if (number == 7)
			return "Juillet";
		if (number == 8)
			return "Août";
		if (number == 9)
			return "Septembre";
		if (number == 10)
			return "Octobre";
		if (number == 11)
			return "Novembre";
		if (number == 12)
			return "Décembre";
		return "Error";
	}

	/**
	 * Mettre à jour le libellé du mois selon la navigation
	 */
	function updateMonth(){
		jq("#grid").jqGrid('destroyGroupHeader');
		jq("#grid").jqGrid("setGroupHeaders", {
			useColSpanStyle : true,
			groupHeaders : [ {
				startColumnName : "1",
				numberOfColumns : 31,
				titleText : "<em>" + getLibMonth(n) + " - " + y + "</em>"
			} ]
		});
	}
});

/**
 * Gérer l'envoi des données au backend
 */
function send(datas) {
	jq.ajax({
		url : './imputations/timesheet/edit',
		type : 'PUT',
		dataType : 'json',
		data : datas,
		contentType : "application/json; charset=utf-8",
		traditional : true,
		success : function(msg) {
			if (msg)
				jq("#ok").prepend(msg.responseText);
		},
		error : function(msg) {
			if (msg)
				jq("#error").prepend(msg.responseText);
		},
	});
}