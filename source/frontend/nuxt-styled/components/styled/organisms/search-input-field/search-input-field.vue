<template lang="html">
  <div class="search-input-field">
    <div class="search-input-field__inner">
      <form action="">
        <fieldset>
          <legend class="hidden">검색 정보입력</legend>
          <div class="search-input-field__search">
            <group-search></group-search>
<!--            <base-button type="button" class="button&#45;&#45;primary button&#45;&#45;lg"><span class="button__text">상세검색</span></base-button>-->
          </div>
          <div class="search-input-field__filter">
            <base-checkbox name="filter-check" checkbox-id="check-1">
              <template v-slot:label>
                결과 내 재검색
              </template>
            </base-checkbox>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</template>

<script type="text/javascript">
import GroupSearch from "@component/styled/molecules/group-search/group-search";
import BaseButton from "@component/styled/atoms/base-button/base-button";
import BaseCheckbox from "@component/styled/atoms/base-checkbox/base-checkbox";
export default {
  name: "SearchInputField",
  extends: {},
  props: {
  },
  data() {
    return {
    };
  },
  computed: {},
  components: { BaseCheckbox, BaseButton, GroupSearch },
  watch: {},
  methods: {},
  beforeCreate() {},
  mounted() {}
};
</script>

<style lang="scss" scoped>
@import "./search-input-field.scss";
</style>
