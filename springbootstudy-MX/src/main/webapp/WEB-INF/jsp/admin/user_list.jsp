<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>用户管理</title>
  <!--引入element-ui.css-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
  <!--引入自定义样式el-custom.css-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--开始使用vue模板-->
<div id="app">
  <!--页面内容区域-->
  <div class="mx-main-content">
    <div class="mx-table-title">
      <span>用户列表</span>&nbsp;&nbsp;
      <el-button
          size="mini"
          type="primary"
          @click='onAdd()'>添加
      </el-button>
    </div>
    <el-divider></el-divider>
    <div class="mx-table-content">
      <!--使用element-ui table组件-->
      <el-table
          v-if="tableData.length > 0"
          :data='tableData'
          :stripe="true"
          style="width: 100%">
        <el-table-column
            type="index"
            label=""
            align='center'
            width="50">
        </el-table-column>
        <el-table-column
            prop="userLoginId"
            label="登录账号">
        </el-table-column>
        <el-table-column
            prop="userName"
            label="姓名">
        </el-table-column>
        <el-table-column
            prop="isSystem"
            label="账号类型"
            align="center"
            width="100">
          <template slot-scope="scope">
            <span v-if="scope.row.isSystem == '0'">普通用户</span>
            <span v-else>系统管理员</span>
          </template>
        </el-table-column>
        <el-table-column
            prop="mobile"
            label="电话号码"
            align="center"
            width="130">
        </el-table-column>
        <el-table-column
            prop="email"
            align="center"
            label="电子邮箱"
            width="180">
        </el-table-column>
        <el-table-column
            prop="currentStatus"
            label="账号状态"
            align="center"
            width="90">
          <template slot-scope="scope">
            <span v-if="scope.row.currentStatus == '0'">正常</span>
            <span v-if="scope.row.currentStatus == '2'">禁用</span>
            <span v-if="scope.row.currentStatus == '4'">未开通</span>
          </template>
        </el-table-column>
        <!--操作按钮-->
        <el-table-column
            label="操作"
            align='center'
            width="220">
          <template slot-scope="scope">
            <el-tooltip class="item" effect="light" content="修改用户信息">
              <el-button size="mini" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
            </el-tooltip>
            <el-tooltip class="item" effect="light" content="删除用户">
              <el-button size="mini" plain type="danger" @click="onDelete(scope.$index)">删除</el-button>
            </el-tooltip>
            <el-tooltip class="item" effect="light" content="重置密码">
              <el-button size="mini" plain type="info" @click="onResetPwd(scope.$index)">密码</el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>

  <!--使用el-dialog组件显示添加表单-->
  <el-dialog
      width="80%"
      :title="dialog.title"
      :visible.sync="dialog.show"
      :close-on-click-modal='false'
      :close-on-press-escape='false'
      :modal-append-to-body='false'>
    <div class="form">
      <!--使用el-form组件进行数据添加和修改-->
      <el-form
          ref="myform"
          :model="mymodel"
          :rules="myrulesAdd"
          label-width="150px"
          style="margin:10px;width:auto;">
        <el-form-item hidden prop='userId' label="ID:">
          <el-input type="string" v-model="mymodel.userId"></el-input>
        </el-form-item>
        <el-form-item label="登录账号" required>
          <el-col :span="15">
            <el-form-item prop='userLoginId'>
              <el-input type="string" v-model="mymodel.userLoginId"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="登录密码" required>
          <el-col :span="15">
            <el-form-item prop='currentPassword'>
              <el-input type="password" v-model="mymodel.currentPassword"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item prop='currentPassword2' label="重复密码">
          <el-col :span="15">
            <el-input type="password" v-model="mymodel.currentPassword2"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item prop='isSystem' label="账号类型:">
          <!--使用label表示值-->
          <el-radio-group v-model="mymodel.isSystem">
            <el-radio-button label="0">普通账号</el-radio-button>
            <el-radio-button label="1">系统管理员</el-radio-button>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="姓名" required>
          <el-col :span="15">
            <el-form-item prop='userName'>
              <el-input type="string" v-model="mymodel.userName"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item prop='mobile' label="手机号码:">
          <el-col :span="15">
            <el-input type="string" v-model="mymodel.mobile"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item prop='email' label="电子邮箱:">
          <el-col :span="15">
            <el-input type="string" v-model="mymodel.email"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item class="text_right">
          <el-button type="primary" @click='onSubmitAdd("myform")'>保 存</el-button>
          <el-button @click="dialog.show = false">取 消</el-button>
        </el-form-item>

      </el-form>
    </div>
  </el-dialog>

  <!--修改用户信息对话框-->
  <el-dialog
      width="80%"
      :title="dialogEdit.title"
      :visible.sync="dialogEdit.show"
      :close-on-click-modal='false'
      :close-on-press-escape='false'
      :modal-append-to-body='false'>
    <div class="form">
      <!--使用el-form组件进行数据添加和修改-->
      <el-form
          ref="myformedit"
          :model="mymodel"
          :rules="myrulesEdit"
          label-width="150px"
          style="margin:10px;width:auto;">
        <el-form-item hidden prop='userId' label="ID:">
          <el-input type="string" v-model="mymodel.userId"></el-input>
        </el-form-item>
        <!--如果是修改,则账号为只读-->
        <el-form-item label="登录账号">
          <el-col :span="15">
            <el-form-item prop='userLoginId'>
              <el-input type="string" readonly v-model="mymodel.userLoginId"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item prop='isSystem' label="账号类型:">
          <!--使用label表示值-->
          <el-radio-group v-model="mymodel.isSystem">
            <el-radio-button label="0">普通账号</el-radio-button>
            <el-radio-button label="1">系统管理员</el-radio-button>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="姓名" required>
          <el-col :span="15">
            <el-form-item prop='userName'>
              <el-input type="string" v-model="mymodel.userName"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item prop='mobile' label="手机号码:">
          <el-col :span="15">
            <el-input type="string" v-model="mymodel.mobile"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item prop='email' label="电子邮箱:">
          <el-col :span="15">
            <el-input type="string" v-model="mymodel.email"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item class="text_right">
          <el-button type="primary" @click='onSubmitEdit("myformedit")'>保 存</el-button>
          <el-button @click="dialog.show = false">取 消</el-button>
        </el-form-item>

      </el-form>
    </div>
  </el-dialog>

  <!--修改密码对话框-->
  <el-dialog
      width="80%"
      :title="dialogPwd.title"
      :visible.sync="dialogPwd.show"
      :close-on-click-modal='false'
      :close-on-press-escape='false'
      :modal-append-to-body='false'>
    <div class="form">
      <el-form
          ref="myformpwd"
          :model="mymodel"
          :rules="myrulesPwd"
          label-width="150px"
          style="margin:10px;width:auto;">
        <el-form-item hidden prop='userId' label="ID:">
          <el-input type="string" v-model="mymodel.userId"></el-input>
        </el-form-item>
        <el-form-item label="登录账号">
          <el-col :span="15">
            <el-form-item prop='userLoginId'>
              <el-input type="string" readonly v-model="mymodel.userLoginId"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="登录密码" required>
          <el-col :span="15">
            <el-form-item prop='currentPassword'>
              <el-input type="password" v-model="mymodel.currentPassword"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item prop='currentPassword2' label="重复密码">
          <el-col :span="15">
            <el-input type="password" v-model="mymodel.currentPassword2"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item class="text_right">
          <el-button type="primary" @click='onSubmitPwd("myformpwd")'>保 存</el-button>
          <el-button @click="dialogPwd.show = false">取 消</el-button>
        </el-form-item>
      </el-form>

    </div>
  </el-dialog>
</div>


<!--引入vue.js-->
<script src="${pageContext.request.contextPath}/static/vue/vue.min.js"></script>
<!--引入element-ui.js-->
<script src="${pageContext.request.contextPath}/static/element-ui/index.js"></script>
<!--引入axios-->
<script src="${pageContext.request.contextPath}/static/axios/axios.min.js"></script>
<!--引入配置js-->
<script src="${pageContext.request.contextPath}/static/mx-config.js"></script>
<script>
  var app = new Vue({
    //模板名称,在html中引用的组件名称
    el: '#app',
    //定义数据
    //可以在html中使用
    data: function () {
      //验证重复密码
      let validatePwd2 = (rule, value, callback) => {
        if (value === "") {
          callback(new Error("请输入确认密码"));
        } else if (value !== this.mymodel.currentPassword) {
          callback(new Error("两次输入密码不一致！"));
        } else {
          callback();
        }
      }
      return {
        //定义表格要的数据
        tableData: [],
        //定义一个变量,存放哪行数据被选中
        selectItemIdex: -1,

        //定义对话框:如果对话框有自定义的数据需要通过变量控制,需要先定义
        dialog: {
          show: false,
          title: "",
          option: ""
        },
        dialogEdit: {
          show: false,
          title: "",
          option: ""
        },
        dialogPwd: {
          show: false,
          title: "",
          option: ""
        },
        //定义模型,通过:model="form"与表单绑定
        mymodel: {
          userId: '',
          userLoginId: '',
          currentPassword: '',
          currentPassword2: '',
          currentStatus: '',
          userName: '',
          lastName: '',
          firstName: '',
          mobile: '',
          email: '',
          isSystem: '0'
        },
        //表单校验规则
        myrulesAdd: {
          userLoginId: [
            {required: true, message: '请输入登录账号', trigger: 'blur'},
            {min: 5, max: 10, message: '长度在 5 到 10 个字符', trigger: 'blur'}
          ],
          userName: [
            {required: true, message: '请输入姓名', trigger: 'blur'},
            {min: 2, max: 20, message: '长度在 2 到 20 个字符', trigger: 'blur'}
          ],
          currentPassword: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 1, max: 18, message: '长度在 1 到 18 个字符', trigger: 'blur'}
          ],
          currentPassword2: [
            { validator:validatePwd2,trigger: 'blur'}
          ]
        },
        myrulesEdit: {
          userName: [
            {required: true, message: '请输入姓名', trigger: 'blur'},
            {min: 2, max: 20, message: '长度在 2 到 20 个字符', trigger: 'blur'}
          ]
        },
        myrulesPwd: {
          currentPassword: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 1, max: 18, message: '长度在 1 到 18 个字符', trigger: 'blur'}
          ],
          currentPassword2: [
            {validator: validatePwd2, trigger: 'blur'}
          ]
        }
      }
    },
    //生命周期函数:mounted--是加载模板后
    //一般初始化的数据都可在这执行
    mounted: function () {
      this.selectData();
    },

    //定义方法,多个方法用逗号(,)分割
    //定义的方法可以在html中通过@xxx使用
    methods: {
      //从服务器获得数据
      selectData() {
        //通过axios调用服务器json服务
        axios.get("/admin/user/").then(res => {
          this.tableData = res.data;
        });
      },

      // 响应添加按钮,弹出添加对话框(与修改共用)
      onAdd() {
        this.dialog = {
          show: true,
          title: "注册用户",
          option: "add"
        };
        //清除校验,需要延迟,否则会由于还未渲染完form,报错
        this.$nextTick(() => {
          this.$refs['myform'].clearValidate();
        });
        this.mymodel = {
          userId: '',
          userLoginId: '',
          currentPassword: '',
          currentPassword2: '',
          currentStatus: '',
          userName: '',
          lastName: '',
          firstName: '',
          mobile: '',
          email: '',
          isSystem: '0'
        };
      },
      onEdit(index) {
        // 编辑
        this.dialogEdit = {
          show: true,
          title: "修改用户信息",
          option: "edit"
        };
        //清除校验,需要延迟,否则会由于还未渲染完form,报错
        this.$nextTick(() => {
          this.$refs['myformedit'].clearValidate();
        });
        //更新model数据
        this.mymodel = {
          userId: this.tableData[index].userId,
          userLoginId: this.tableData[index].userLoginId,
          currentPassword: '',
          currentPassword2: '',
          currentStatus: this.tableData[index].currentStatus,
          userName: this.tableData[index].userName,
          lastName: this.tableData[index].lastName,
          firstName: this.tableData[index].firstName,
          mobile: this.tableData[index].mobile,
          email: this.tableData[index].email,
          isSystem: this.tableData[index].isSystem
        };
        //设置哪行被选中了
        this.selectItemIdex = index;
      },

      onResetPwd(index) {
        // 重置密码
        this.dialogPwd = {
          show: true,
          title: "重置密码",
          option: "pwd"
        };
        //清除校验,需要延迟,否则会由于还未渲染完form,报错
        this.$nextTick(() => {
          this.$refs['myformpwd'].clearValidate();
        });
        //更新model数据
        this.mymodel = {
          userId: this.tableData[index].userId,
          userLoginId: this.tableData[index].userLoginId,
          currentPassword: '',
          currentPassword2: '',
        };
        //设置哪行被选中了
        this.selectItemIdex = index;
      },
      // 响应删除按钮
      onDelete(index) {
        this.$confirm('确认删除该数据吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 删除
          axios.delete("/admin/user/" + this.tableData[index].userId).then(res => {
            this.$message("删除成功");
            // 删除table起始下标为1，长度为1的一个值
            this.tableData.splice(index, 1);
          });
        }).catch(() => {

        });
      },
      // 响应添加/修改对话框中的保存按钮
      onSubmitAdd(formName) {
        //表单校验
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            this.$message({
              message: "输入项有错误！",
              type: "error"
            });
            return false;
          } else {
            //添加,调用post方法
            axios.post("/admin/user/", this.mymodel).then(res => {
              // 操作成功
              this.$message({
                message: "保存成功！",
                type: "success"
              });
              //方法1:更新table
              this.tableData.push(res.data);
              //方法2:更新table:在最后添加一个元素,0表示添加
              //this.tableData.splice(this.tableData.length,0,res.data);
              //关闭对话框
              this.dialog.show = false;
            })
          }
        })
      },
      //修改,调用put方法
      onSubmitEdit(formName) {
        //表单校验
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            this.$message({
              message: "输入项有错误！",
              type: "error"
            });
            return false;
          } else {

            axios.put("/admin/user/", this.mymodel).then(res => {
              // 操作成功
              this.$message({
                message: "保存成功！",
                type: "success"
              });

              // 方法1:更新指定索引的元素
              this.tableData.splice(this.selectItemIdex, 1, res.data)
              // 方法2:数据重新从服务器加载table数据,这种方法效率差
              // this.getData();
              // 关闭对话框
              this.dialogEdit.show = false;
            })
          }
        })
      },
      //修改密码
      onSubmitPwd(formName) {
        //表单校验
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            this.$message({
              message: "输入项有错误！",
              type: "error"
            });
            return false;
          } else {
            axios.put("/admin/resetpwd/", this.mymodel).then(res => {
              // 操作成功
              this.$message({
                message: "修改成功！",
                type: "success"
              });
              // 关闭对话框
              this.dialogPwd.show = false;
            })
          }
        })
      },
      // 手机号验证
      isValidPhone: function (str) {
        const reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
        return reg.test(str);
      },

      // 验证密码
      // 密码，以字母开头，长度在6~18之间，只能包含字母、数字和下划线
      isValidPwd: function (str) {
        const reg = /^[a-zA-Z]\w{6,18}$/;
        return reg.test(str);
      },

    }
  })
</script>
</body>
</html>