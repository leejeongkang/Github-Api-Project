<template>
  <div>
    <main class="main">
      <nuxt/>
    </main>
    <Footer/>
  </div>
</template>

<script type="text/javascript">
import Footer from "./footer/footer.vue";

export default {
  name: "LoginLayout",
  components: {
    Footer
  }
};
</script>

<style lang="scss" scoped>
footer {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  width: 100%;
}
</style>
