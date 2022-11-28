<template>
  <div>
    <sample-header />
    <main class="main">
      <nuxt />
    </main>
    <sample-footer />
  </div>
</template>

<script type="text/javascript">
import SampleHeader from "./header/sample/header.vue";
import SampleFooter from "./footer/footer.vue";

export default {
  name: "SampleLayout",
  components: {
    SampleHeader,
    SampleFooter
  }
};
</script>
