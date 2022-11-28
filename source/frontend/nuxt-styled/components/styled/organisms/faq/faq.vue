<template lang="html">
  <div>
    <div class="faq__tool-bar">
      <div class="checkboxes checkboxes--toggle">
        <base-checkbox name="filter-check" checkboxId="1" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            전체
          </template>
        </base-checkbox>
        <base-checkbox name="filter-check" checkboxId="2" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            데이터
          </template>
        </base-checkbox>
        <base-checkbox name="filter-check" checkboxId="3" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            회원가입
          </template>
        </base-checkbox>
        <base-checkbox name="filter-check" checkboxId="4" class="checkbox--toggle checkbox--sm">
          <template v-slot:label>
            기타
          </template>
        </base-checkbox>
      </div>
      <div class="text-input-group">
        <label class="hidden">Label</label>
        <base-input placeholder="placeholder text"></base-input>
        <base-button class="text-input-group__clear-button" title="초기화">
          <svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon>
        </base-button>
        <base-button title="검색" class="text-input-group__search-button button--icon button--link">
          <svg-icon class="svg-icon button__icon" name="search" aria-hidden="true"></svg-icon>
        </base-button>
      </div>
    </div>
    <group-faq></group-faq>
  </div>
</template>

<script type="text/javascript">
import GroupFaq from "@molecules/group-faq/group-faq.vue";
import BaseButton from "@atoms/Base-Button/base-button.vue";
import BaseInput from "@atoms/Base-Input/base-input.vue";
import BaseCheckbox from "@atoms/Base-Checkbox/base-checkbox.vue";

export default {
  name: "Faq",
  extends: {},
  watch: {},
  methods: {},
  components: {GroupFaq, BaseButton, BaseInput, BaseCheckbox}
};
</script>

<style lang="scss" scoped>
@import "./faq.scss";
</style>
