(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-fenxibaogao-add-or-update"],{3867:function(e,n,i){"use strict";var r=i("4ea4");Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0,i("a481"),i("c5f6"),i("f559"),i("456d"),i("ac6a"),i("96cf");var t=r(i("3b8d")),a=r(i("e2b1")),o=r(i("064f")),s=r(i("bd56")),u={data:function(){return{cross:"",ruleForm:{yonghuzhanghao:"",yonghuxingming:"",nianling:"",xingbie:"",fenxijianjie:"",fenxixiangqing:"",fenxishijian:""},yonghuzhanghaoOptions:[],yonghuzhanghaoIndex:0,user:{},ro:{yonghuzhanghao:!1,yonghuxingming:!1,nianling:!1,xingbie:!1,fenxijianjie:!1,fenxixiangqing:!1,fenxishijian:!1}}},components:{wPicker:a.default,xiaEditor:o.default,multipleSelect:s.default},watch:{},onLoad:function(){var e=(0,t.default)(regeneratorRuntime.mark((function e(n){var i,r,t,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return this.ruleForm.fenxishijian=this.$utils.getCurDateTime(),i=uni.getStorageSync("nowTable"),e.next=4,this.$api.session(i);case 4:return r=e.sent,this.user=r.data,e.next=8,this.$api.option("yonghu","yonghuzhanghao",{});case 8:if(r=e.sent,this.yonghuzhanghaoOptions=r.data,this.ruleForm.userid=uni.getStorageSync("userid"),n.refid&&(this.ruleForm.refid=n.refid,this.ruleForm.nickname=uni.getStorageSync("nickname")),!n.id){e.next=18;break}return this.ruleForm.id=n.id,e.next=16,this.$api.info("fenxibaogao",this.ruleForm.id);case 16:r=e.sent,this.ruleForm=r.data;case 18:if(this.cross=n.cross,!n.cross){e.next=54;break}t=uni.getStorageSync("crossObj"),e.t0=regeneratorRuntime.keys(t);case 22:if((e.t1=e.t0()).done){e.next=54;break}if(a=e.t1.value,"yonghuzhanghao"!=a){e.next=28;break}return this.ruleForm.yonghuzhanghao=t[a],this.ro.yonghuzhanghao=!0,e.abrupt("continue",22);case 28:if("yonghuxingming"!=a){e.next=32;break}return this.ruleForm.yonghuxingming=t[a],this.ro.yonghuxingming=!0,e.abrupt("continue",22);case 32:if("nianling"!=a){e.next=36;break}return this.ruleForm.nianling=t[a],this.ro.nianling=!0,e.abrupt("continue",22);case 36:if("xingbie"!=a){e.next=40;break}return this.ruleForm.xingbie=t[a],this.ro.xingbie=!0,e.abrupt("continue",22);case 40:if("fenxijianjie"!=a){e.next=44;break}return this.ruleForm.fenxijianjie=t[a],this.ro.fenxijianjie=!0,e.abrupt("continue",22);case 44:if("fenxixiangqing"!=a){e.next=48;break}return this.ruleForm.fenxixiangqing=t[a],this.ro.fenxixiangqing=!0,e.abrupt("continue",22);case 48:if("fenxishijian"!=a){e.next=52;break}return this.ruleForm.fenxishijian=t[a],this.ro.fenxishijian=!0,e.abrupt("continue",22);case 52:e.next=22;break;case 54:this.styleChange(),this.$forceUpdate();case 56:case"end":return e.stop()}}),e,this)})));function n(n){return e.apply(this,arguments)}return n}(),methods:{fenxixiangqingChange:function(e){this.ruleForm.fenxixiangqing=e},styleChange:function(){this.$nextTick((function(){document.querySelectorAll(".radioText").forEach((function(e){e.removeAttribute("style");var n={color:"#666666"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))})),document.querySelectorAll(".radioTextActive").forEach((function(e){e.removeAttribute("style");var n={color:"#00babd"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))})),document.querySelectorAll(".checkText").forEach((function(e){e.removeAttribute("style");var n={color:"#666666"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))})),document.querySelectorAll(".checkTextActive").forEach((function(e){e.removeAttribute("style");var n={color:"#00babd"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))})),document.querySelectorAll(".uni-radio-input").forEach((function(e){e.removeAttribute("style");var n={border:"2rpx solid #999999",borderRadius:"100%",background:"#ffffff"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))})),document.querySelectorAll(".uni-radio-input-checked").forEach((function(e){e.removeAttribute("style");var n={border:"2rpx solid #00babd",borderRadius:"100%",background:"#19d2d5"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))})),document.querySelectorAll(".uni-checkbox-input").forEach((function(e){e.removeAttribute("style");var n={border:"2rpx solid #999999",borderRadius:"100%",background:"#ffffff"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))})),document.querySelectorAll(".uni-checkbox-input-checked").forEach((function(e){e.removeAttribute("style");var n={border:"2rpx solid #00babd",color:"#ffffff",borderRadius:"100%",background:"#19d2d5"};Object.keys(n).forEach((function(i){e.style[i]=n[i]}))}))}))},yonghuzhanghaoChange:function(){var e=(0,t.default)(regeneratorRuntime.mark((function e(n){var i;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return this.yonghuzhanghaoIndex=n.target.value,this.ruleForm.yonghuzhanghao=this.yonghuzhanghaoOptions[this.yonghuzhanghaoIndex],e.next=4,this.$api.follow("yonghu","yonghuzhanghao",{columnValue:this.ruleForm.yonghuzhanghao});case 4:i=e.sent,i.data.yonghuxingming&&(this.ruleForm.yonghuxingming=i.data.yonghuxingming),i.data.nianling&&(this.ruleForm.nianling=i.data.nianling),i.data.xingbie&&(this.ruleForm.xingbie=i.data.xingbie);case 8:case"end":return e.stop()}}),e,this)})));function n(n){return e.apply(this,arguments)}return n}(),fenxishijianConfirm:function(e){console.log(e),this.ruleForm.fenxishijian=e.result,this.$forceUpdate()},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var e=(0,t.default)(regeneratorRuntime.mark((function e(){var n,i,r,t,a,o,s,u,c,l;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!this.cross){e.next=17;break}if(uni.setStorageSync("crossCleanType",!0),a=uni.getStorageSync("statusColumnName"),o=uni.getStorageSync("statusColumnValue"),""==a){e.next=17;break}if(n||(n=uni.getStorageSync("crossObj")),a.startsWith("[")){e.next=13;break}for(s in n)s==a&&(n[s]=o);return u=uni.getStorageSync("crossTable"),e.next=11,this.$api.update("".concat(u),n);case 11:e.next=17;break;case 13:i=Number(uni.getStorageSync("userid")),r=n["id"],t=uni.getStorageSync("statusColumnName"),t=t.replace(/\[/,"").replace(/\]/,"");case 17:if(!r||!i){e.next=40;break}return this.ruleForm.crossuserid=i,this.ruleForm.crossrefid=r,c={page:1,limit:10,crossuserid:i,crossrefid:r},e.next=23,this.$api.list("fenxibaogao",c);case 23:if(l=e.sent,!(l.data.total>=t)){e.next=30;break}return this.$utils.msg(uni.getStorageSync("tips")),uni.removeStorageSync("crossCleanType"),e.abrupt("return",!1);case 30:if(!this.ruleForm.id){e.next=35;break}return e.next=33,this.$api.update("fenxibaogao",this.ruleForm);case 33:e.next=37;break;case 35:return e.next=37,this.$api.add("fenxibaogao",this.ruleForm);case 37:this.$utils.msgBack("提交成功");case 38:e.next=48;break;case 40:if(!this.ruleForm.id){e.next=45;break}return e.next=43,this.$api.update("fenxibaogao",this.ruleForm);case 43:e.next=47;break;case 45:return e.next=47,this.$api.add("fenxibaogao",this.ruleForm);case 47:this.$utils.msgBack("提交成功");case 48:case"end":return e.stop()}}),e,this)})));function n(){return e.apply(this,arguments)}return n}(),optionsChange:function(e){this.index=e.target.value},bindDateChange:function(e){this.date=e.target.value},getDate:function(e){var n=new Date,i=n.getFullYear(),r=n.getMonth()+1,t=n.getDate();return"start"===e?i-=60:"end"===e&&(i+=2),r=r>9?r:"0"+r,t=t>9?t:"0"+t,"".concat(i,"-").concat(r,"-").concat(t)},toggleTab:function(e){this.$refs[e].show()}}};n.default=u},"5c8f":function(e,n,i){var r=i("24fb");n=r(!1),n.push([e.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.content[data-v-44b7938c]{min-height:calc(100vh - 44px);box-sizing:border-box}',""]),e.exports=n},"65fa":function(e,n,i){"use strict";var r=i("8e92"),t=i.n(r);t.a},"8e92":function(e,n,i){var r=i("5c8f");"string"===typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);var t=i("4f06").default;t("3d48af5c",r,!0,{sourceMap:!1,shadowMode:!1})},9999:function(e,n,i){"use strict";i.r(n);var r=i("f501"),t=i("d6be");for(var a in t)"default"!==a&&function(e){i.d(n,e,(function(){return t[e]}))}(a);i("65fa");var o,s=i("f0c5"),u=Object(s["a"])(t["default"],r["b"],r["c"],!1,null,"44b7938c",null,!1,r["a"],o);n["default"]=u.exports},d6be:function(e,n,i){"use strict";i.r(n);var r=i("3867"),t=i.n(r);for(var a in r)"default"!==a&&function(e){i.d(n,e,(function(){return r[e]}))}(a);n["default"]=t.a},f501:function(e,n,i){"use strict";var r={"xia-editor":i("064f").default,"w-picker":i("e2b1").default},t=function(){var e=this,n=e.$createElement,i=e._self._c||n;return i("v-uni-view",{staticClass:"content"},[i("v-uni-view",{style:{width:"100%",padding:"0 0 0 0",position:"relative",background:"#ffffff",height:"100%"}},[i("v-uni-form",{staticClass:"app-update-pv",style:{width:"100%",padding:"24rpx 24rpx 24rpx 24rpx",background:"#ffffff",display:"block",height:"auto"}},[i("v-uni-view",{staticClass:"select",style:{padding:"4rpx 0 4rpx 0",margin:"0 0 24rpx 0",borderColor:"#cccccc",alignItems:"center",borderRadius:"8rpx 0 0 8rpx",borderWidth:"0px",background:"#e7fefc",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#333333",textAlign:"right"}},[e._v("用户账号")]),i("v-uni-picker",{style:{width:"100%",flex:"1",height:"auto"},attrs:{value:e.yonghuzhanghaoIndex,range:e.yonghuzhanghaoOptions},on:{change:function(n){arguments[0]=n=e.$handleEvent(n),e.yonghuzhanghaoChange.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"uni-input",style:{width:"100%",lineHeight:"80rpx",fontSize:"28rpx",color:"#666666"}},[e._v(e._s(e.yonghuzhanghaoOptions[e.yonghuzhanghaoIndex]))])],1)],1),i("v-uni-view",{style:{padding:"4rpx 0 4rpx 0",margin:"0 0 24rpx 0",borderColor:"#cccccc",alignItems:"center",borderRadius:"8rpx 0 0 8rpx",borderWidth:"0px",background:"#e7fefc",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#333333",textAlign:"right"}},[e._v("用户姓名")]),i("v-uni-input",{style:{border:"0px solid #eeeeee",padding:"0px 24rpx 0px 24rpx",margin:"0 0 0 0",color:"#666666",borderRadius:"8rpx",flex:"1",background:"#ffffff00",fontSize:"28rpx",lineHeight:"80rpx",height:"80rpx"},attrs:{disabled:e.ro.yonghuxingming,placeholder:"用户姓名"},model:{value:e.ruleForm.yonghuxingming,callback:function(n){e.$set(e.ruleForm,"yonghuxingming",n)},expression:"ruleForm.yonghuxingming"}})],1),i("v-uni-view",{style:{padding:"4rpx 0 4rpx 0",margin:"0 0 24rpx 0",borderColor:"#cccccc",alignItems:"center",borderRadius:"8rpx 0 0 8rpx",borderWidth:"0px",background:"#e7fefc",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#333333",textAlign:"right"}},[e._v("年龄")]),i("v-uni-input",{style:{border:"0px solid #eeeeee",padding:"0px 24rpx 0px 24rpx",margin:"0 0 0 0",color:"#666666",borderRadius:"8rpx",flex:"1",background:"#ffffff00",fontSize:"28rpx",lineHeight:"80rpx",height:"80rpx"},attrs:{disabled:e.ro.nianling,placeholder:"年龄"},model:{value:e.ruleForm.nianling,callback:function(n){e.$set(e.ruleForm,"nianling",n)},expression:"ruleForm.nianling"}})],1),i("v-uni-view",{style:{padding:"4rpx 0 4rpx 0",margin:"0 0 24rpx 0",borderColor:"#cccccc",alignItems:"center",borderRadius:"8rpx 0 0 8rpx",borderWidth:"0px",background:"#e7fefc",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#333333",textAlign:"right"}},[e._v("性别")]),i("v-uni-input",{style:{border:"0px solid #eeeeee",padding:"0px 24rpx 0px 24rpx",margin:"0 0 0 0",color:"#666666",borderRadius:"8rpx",flex:"1",background:"#ffffff00",fontSize:"28rpx",lineHeight:"80rpx",height:"80rpx"},attrs:{disabled:e.ro.xingbie,placeholder:"性别"},model:{value:e.ruleForm.xingbie,callback:function(n){e.$set(e.ruleForm,"xingbie",n)},expression:"ruleForm.xingbie"}})],1),i("v-uni-view",{style:{padding:"4rpx 0 4rpx 0",margin:"0 0 24rpx 0",borderColor:"#cccccc",alignItems:"center",borderRadius:"8rpx 0 0 8rpx",borderWidth:"0px",background:"#e7fefc",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#333333",textAlign:"right"}},[e._v("分析时间")]),i("v-uni-input",{style:{border:"0px solid #eeeeee",padding:"0px 24rpx 0px 24rpx",margin:"0 0 0 0",color:"#666666",borderRadius:"8rpx",flex:"1",background:"#ffffff00",fontSize:"28rpx",lineHeight:"80rpx",height:"80rpx"},attrs:{placeholder:"分析时间"},on:{click:function(n){arguments[0]=n=e.$handleEvent(n),e.toggleTab("fenxishijian")}},model:{value:e.ruleForm.fenxishijian,callback:function(n){e.$set(e.ruleForm,"fenxishijian",n)},expression:"ruleForm.fenxishijian"}})],1),i("v-uni-view",{style:{padding:"4rpx 0 4rpx 0",margin:"0 0 24rpx 0",borderColor:"#cccccc",alignItems:"center",borderRadius:"8rpx 0 0 8rpx",borderWidth:"0px",background:"#e7fefc",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#333333",textAlign:"right"}},[e._v("分析简介")]),i("v-uni-textarea",{style:{border:"0px solid #eeeeee",padding:"24rpx 24rpx 24rpx 24rpx",margin:"0 0 0 0",color:"#000000",borderRadius:"8rpx",flex:"1",background:"none",fontSize:"28rpx",height:"240rpx"},attrs:{placeholder:"分析简介"},model:{value:e.ruleForm.fenxijianjie,callback:function(n){e.$set(e.ruleForm,"fenxijianjie",n)},expression:"ruleForm.fenxijianjie"}})],1),i("v-uni-view",{style:{padding:"12rpx 0 12rpx 0",margin:"0 0 24rpx 0",borderColor:"#cccccc",borderWidth:"0 0 0px 0",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"100%",lineHeight:"80rpx",fontSize:"28rpx",color:"#333333",fontWeight:"500"}},[e._v("分析详情")]),i("xia-editor",{ref:"editor",style:{minHeight:"300rpx",border:"0px solid #efefef",padding:"20rpx",color:"#666666",borderRadius:"8rpx 0 0 8rpx",background:"#e7fefc",width:"100%",height:"auto"},attrs:{placeholder:"分析详情"},on:{editorChange:function(n){arguments[0]=n=e.$handleEvent(n),e.fenxixiangqingChange.apply(void 0,arguments)}},model:{value:e.ruleForm.fenxixiangqing,callback:function(n){e.$set(e.ruleForm,"fenxixiangqing",n)},expression:"ruleForm.fenxixiangqing"}})],1),i("v-uni-view",{staticClass:"btn",style:{width:"100%",justifyContent:"center",display:"flex",height:"auto"}},[i("v-uni-button",{staticClass:"bg-red",style:{border:"0px solid #eeeeee",padding:"0 0 0 0",boxShadow:"0px 12rpx 12rpx -12rpx #228a7f",margin:"0 4% 0 0",color:"#ffffff",borderRadius:"40rpx 0 0 0",background:"#75ebde",width:"30%",lineHeight:"80rpx",fontSize:"28rpx",height:"80rpx"},on:{click:function(n){arguments[0]=n=e.$handleEvent(n),e.onSubmitTap.apply(void 0,arguments)}}},[e._v("提交")])],1)],1),i("w-picker",{ref:"fenxishijian",attrs:{mode:"dateTime",step:"1",current:!1,hasSecond:!1,themeColor:"#333333"},on:{confirm:function(n){arguments[0]=n=e.$handleEvent(n),e.fenxishijianConfirm.apply(void 0,arguments)}}})],1)],1)},a=[];i.d(n,"b",(function(){return t})),i.d(n,"c",(function(){return a})),i.d(n,"a",(function(){return r}))}}]);