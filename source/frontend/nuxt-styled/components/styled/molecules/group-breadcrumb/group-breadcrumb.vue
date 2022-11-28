<template lang="html">
  <div class="breadcrumb__list pc-only">
    <ol class="breadcrumbs__list">
      <li class="breadcrumbs__item breadcrumbs__item--home"><span title="홈">홈</span></li>
      <li class="breadcrumbs__item" v-for="(item, index) in contents" :key="index">
        <span @click="onClickItem(item)">{{ item.title }}</span>
      </li>
    </ol>
  </div>
</template>
<script type="text/javascript">
import { mapGetters } from "vuex";

export default {
  name: "GroupBreadcrumb",
  extends: {},
  props: {
    list: {
      type: Array,
      default: function () {
        return [
          { key: "1", title: "home" },
          { key: "2", title: "shop" },
          { key: "3", title: "about" }
        ];
      }
    }
  },
  computed: {
    contents: function () {
      return this.list;
    }
  },
  components: {},
  watch: {},
  methods: {
    onClickItem(item) {
      this.$emit("select", item);
    }
  }
};
</script>

<style lang="scss" scoped>
@import "./group-breadcrumb.scss";
</style>
