<template lang="html">
  <!--  수평 방향 - search-filter-group--horizontal / 수직 방향 - search-filter-group--vertical -->
  <div class="search-filter-group">
    <group-search-filter></group-search-filter>
    <group-search-filter></group-search-filter>
    <group-search-filter></group-search-filter>
  </div>
</template>

<script type="text/javascript">
import GroupSearchFilter from "@component/styled/molecules/group-search-filter/group-search-filter";
export default {
  name: "SearchFilterGroup",
  extends: {},
  props: {
  },
  data() {
    return {
    };
  },
  computed: {},
  components: { GroupSearchFilter },
  watch: {},
  methods: {},
  beforeCreate() {},
  mounted() {}
};
</script>

<style lang="scss" scoped>
@import "./search-filter-group";
</style>
