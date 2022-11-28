<template lang="html">
  <div>
    <Login @login="onLogin" />
  </div>
</template>

<i18n src="./index.json"></i18n>

<script type="text/javascript">
import Login from "@organisms/login/login.vue";
import { successAlert } from "@functional/alert/alert-default";
import { mapMutations } from "vuex";

import RSA from "rsajs";

export default {
  name: "LoginForm",
  layout: "sample/login",
  components: {
    Login
  },
  methods: {
    ...mapMutations({
      setUser: "setUser"
    }),
    async onLogin(param) {
      let publicKey = await this.getPublicKey();
      let password = param.password;

      if (publicKey && publicKey !== "") {
        password = this.encrypt(publicKey, param.password);
      }

      let xAccessToken = await this.auth(param.username, password);
      console.info(publicKey, xAccessToken);

      if (xAccessToken && xAccessToken !== "") {
        this.$cookies.set("x-access-token", xAccessToken);

        successAlert(this.$t("login.login-success")).then((p) => {
          let user = {
            username: param.username
          };
          this.setUser(user);
          this.$router.go(-1);
        });
      }
    },
    getPublicKey() {
      return this.$axios.get("/api/authenticate/key");
    },
    auth(username, password) {
      return this.$axios.post("/api/authenticate", {
        username: username,
        password: password
      });
    },
    encrypt(key, source) {
      const encrypt = new RSA();
      encrypt.setKey(key);

      return encrypt.encrypt(source);
    }
  }
};
</script>
