<template lang="html">
  <div class="detail-filter">
    <base-button class="detail-filter__toggle-button button--link">
      <span class="button__text">상세필터보기</span>
      <svg-icon name="chevron-down-medium" class="svg-icon"/><span class="hidden">열기</span>
    </base-button>
    <div class="detail-filter__group">
    <strong class="detail-filter__title">카테고리</strong>
      <div class="detail-filter__checkboxes">
        <base-checkbox name="filter-check" checkboxId="1" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            자동차 부품
          </template>
        </base-checkbox>
        <base-checkbox name="filter-check" checkboxId="2" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            자동차 제조
          </template>
        </base-checkbox>
        <base-checkbox name="filter-check" checkboxId="3" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            화물운송 서비스
          </template>
        </base-checkbox>
        <base-checkbox name="filter-check" checkboxId="4" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            관련서비스 산업
          </template>
        </base-checkbox>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import BaseCheckbox from "@atoms/base-checkbox/base-checkbox.vue";
import BaseButton from "@component/styled/atoms/base-button/base-button";

export default {
  name: "GroupDetailFilter",
  props: {
  },
  components: {
    BaseButton,
    BaseCheckbox
  }
};
</script>

<style lang="scss" scoped>
@import "./group-detail-filter.scss";
</style>
