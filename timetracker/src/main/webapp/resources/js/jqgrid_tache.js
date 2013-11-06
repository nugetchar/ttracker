 var jq = jQuery.noConflict();
 jq(function() {
  jq("#grid").jqGrid({
      url:'./taches/manage',
   datatype: 'json',
   mtype: 'GET',
      colNames:['Projet', 'Tache', 'Date', 'Fini', 'Temps de travail'],
      colModel:[
       {name:'projet',index:'projet', width:55,editable:false,editoptions:{readonly:true,size:10},hidden:true},
       {name:'tache',index:'tache', width:100,editable:true, editrules:{required:true}, editoptions:{size:10}},
       {name:'date',index:'date', width:100,editable:true, editrules:{required:true}, editoptions:{size:10}},
       {name:'fini',index:'fini', width:100,editable:true, editrules:{required:true}, editoptions:{size:10}},
       {name:'tempttravail',index:'tempstravail', width:100,editable:true, editrules:{required:true}, editoptions:{size:10}}
      ],
      postData: { 
   },
   rowNum:20,
      rowList:[20,40,60],
      height: 200,
      autowidth: true,
   rownumbers: true,
      pager: '#pager',
      sortname: 'id',
      viewrecords: true,
      sortorder: "asc",
      caption:"Taches",
      emptyrecords: "Empty records",
      loadonce: false,
      loadComplete: function() {
   },
      jsonReader : {
          root: "rows",
          page: "page",
          total: "total",
          records: "records",
          repeatitems: false,
          cell: "cell",
          id: "id"
      }
  });
  jq("#grid").jqGrid('navGrid','#pager',
    {edit:false,add:false,del:false,search:true},
    { },
          { },
          { }, 
    { 
        sopt:['eq', 'ne', 'lt', 'gt', 'cn', 'bw', 'ew'],
           closeOnEscape: true, 
            multipleSearch: true, 
             closeAfterSearch: true }
  );
 
 
   
  jq("#grid").navButtonAdd('#pager',
    {  caption:"Add", 
     buttonicon:"ui-icon-plus", 
     onClickButton: addRow,
     position: "last", 
     title:"", 
     cursor: "pointer"
    } 
  );
   
  jq("#grid").navButtonAdd('#pager',
    {  caption:"Edit", 
     buttonicon:"ui-icon-pencil", 
     onClickButton: editRow,
     position: "last", 
     title:"", 
     cursor: "pointer"
    } 
  );
   
  jq("#grid").navButtonAdd('#pager',
   {  caption:"Delete", 
    buttonicon:"ui-icon-trash", 
    onClickButton: deleteRow,
    position: "last", 
    title:"", 
    cursor: "pointer"
   } 
  );
 
  jq("#btnFilter").click(function(){
   jq("#grid").jqGrid('searchGrid',
     {multipleSearch: false, 
      sopt:['eq']}
   );
  });
 
  // Toolbar Search
  jq("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});
 
 });
 
function addRow() {
 
 // Get the currently selected row
    jq("#grid").jqGrid('editGridRow','new',
      {  url: "/spring-jqgrid-integration/krams/crud/add", 
     editData: {
       },
       recreateForm: true,
       beforeShowForm: function(form) {
       },
    closeAfterAdd: true,
    reloadAfterSubmit:false,
    afterSubmit : function(response, postdata) 
    { 
           var result = eval('(' + response.responseText + ')');
     var errors = "";
      
           if (result.success == false) {
      for (var i = 0; i < result.message.length; i++) {
       errors +=  result.message[i] + "";
      }
           }  else {
            jq("#dialog").text('Entry has been added successfully');
      jq("#dialog").dialog( 
        { title: 'Success',
         modal: true,
         buttons: {"Ok": function()  {
          jq(this).dialog("close");} 
         }
        });
                 }
        // only used for adding new records
        var new_id = null;
         
     return [result.success, errors, new_id];
    }
      });
 
}
 
function editRow() {
 // Get the currently selected row
 var row = jq("#grid").jqGrid('getGridParam','selrow');
  
 if( row != null ) 
  jq("#grid").jqGrid('editGridRow',row,
   { url: "/spring-jqgrid-integration/krams/crud/edit", 
    editData: {
          },
          recreateForm: true,
          beforeShowForm: function(form) {
          },
    closeAfterEdit: true,
    reloadAfterSubmit:false,
    afterSubmit : function(response, postdata) 
    { 
              var result = eval('(' + response.responseText + ')');
     var errors = "";
      
              if (result.success == false) {
      for (var i = 0; i < result.message.length; i++) {
       errors +=  result.message[i] + "";
      }
              }  else {
               jq("#dialog").text('Entry has been edited successfully');
      jq("#dialog").dialog( 
        { title: 'Success',
         modal: true,
         buttons: {"Ok": function()  {
          jq(this).dialog("close");} 
         }
        });
                 }
            
     return [result.success, errors, null];
    }
   });
 else jq( "#dialogSelectRow" ).dialog();
}
 
function deleteRow() {
 // Get the currently selected row
    var row = jq("#grid").jqGrid('getGridParam','selrow');
 
    // A pop-up dialog will appear to confirm the selected action
 if( row != null ) 
  jq("#grid").jqGrid( 'delGridRow', row,
           { url: '/spring-jqgrid-integration/krams/crud/delete', 
      recreateForm: true,
               beforeShowForm: function(form) {
                 //change title
                 jq(".delmsg").replaceWith('<span style="white-space: pre;">' +
                   'Delete selected record?' + '</span>');
                  
        //hide arrows
                 jq('#pData').hide();  
                 jq('#nData').hide();  
               },
              reloadAfterSubmit:false,
              closeAfterDelete: true,
              afterSubmit : function(response, postdata) 
      { 
                   var result = eval('(' + response.responseText + ')');
       var errors = "";
        
                   if (result.success == false) {
        for (var i = 0; i < result.message.length; i++) {
         errors +=  result.message[i] + "";
        }
                   }  else {
                    jq("#dialog").text('Entry has been deleted successfully');
        jq("#dialog").dialog( 
          { title: 'Success',
           modal: true,
           buttons: {"Ok": function()  {
            jq(this).dialog("close");} 
           }
          });
                   }
                   // only used for adding new records
                   var new_id = null;
                    
       return [result.success, errors, new_id];
      }
           });
  else jq( "#dialogSelectRow" ).dialog();
}
 