<template lang="html">
  <div>
    <Menu mode="horizontal" class="header" theme="primary" active-name="1">
      <div class="lushx-logo">
        <a href="/">LushX</a>
      </div>
      <li class="nav-item" @click="auth()">
        <a class="lushx-link login-link">{{ navText }}</a>
      </li>
    </Menu>
    <auth-modal v-model="showAuthModal"></auth-modal>
  </div>
</template>


<script>
  import AuthModal from '~/components/AuthModal'

  export default {
    name: "Header",
    props: {
      navText: {
        type: String,
        default: '登录'
      }
    },
    data() {
      return {
        showAuthModal: false,
        statusText: '登录'
      }
    },
    components: {
      AuthModal
    },
    computed: {

      // navText: {
      //   get() {
      //     return this.statusText
      //   },
      //   set() {
      //     if(this.authorization && this.$route.path !== '/user') {
      //       this.statusText = '个人中心'
      //     } else if(this.authorization && this.$route.path === '/user') {
      //       this.statusText = '首页'
      //     } else {
      //       this.statusText = '登录'
      //     }
      //   }
      // }
    },
    // watch: {
    //   authorization(a) {
    //     if(this.authorization && this.$route.path !== '/user') {
    //       this.statusText = '个人中心'
    //     } else if(this.authorization && this.$route.path === '/user') {
    //       this.statusText = '首页'
    //     } else {
    //       this.statusText = '登录'
    //     }
    //   }
    // },
    methods: {
      auth() {
        switch (this.navText) {
          case '登录':
            this.showAuthModal = !this.showAuthModal
            break

          case '首页':
            this.$router.push({ name: 'index' })
            break

          case '个人中心':
            this.$router.push({ name: 'user' })
            break

          default:
            break
        }
      }
    }
  }
</script>


<style lang="less" scoped>
  .header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 999;
  }
  .lushx-logo {
    padding-left: 28px;
    display: inline-block;
    & > a {
      display: block;
      line-height: 60px;
      font-size: 30px;
      font-weight: 900;
      transition: .25s;
      color: #1abc9c;
      text-decoration: none;
      cursor: pointer;
      &:hover {
        color: #fff;
        background-color: transparent;
        text-decoration: none;
      }
    }
  }

  .nav-item {
    height: 100%;
    float: right;
  }

  .lushx-link {
    padding-right: 18px;
    display: inline-block;
    line-height: 60px;
    font-size: 18px;
    font-weight: 700;
    transition: .25s;
    color: #fff;
    text-decoration: none;
    cursor: pointer;
    &:hover {
      color: #1abc9c;
      background-color: transparent;
      text-decoration: none;
    }
  }

  .ivu-menu-horizontal .ivu-menu-item, .ivu-menu-horizontal .ivu-menu-submenu {
    float: right;
  }

  @media (max-width: 768px) {
    .lushx-logo {
      padding-left: 3px;
    }
    .lushx-link {
      padding-right: 3px;
    }
  }
</style>
