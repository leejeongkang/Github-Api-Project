<template lang="html">
  <div class="ui-template">
    <div class="ui-template__content">
      <h4 class="ui-template__title">Radio Group</h4>
      <div class="radios radios--toggle">
        <base-radio name="radio-1" radioId="radioId1" class="radio--lg" checked>
          <template v-slot:label> 직접 입력 </template>
        </base-radio>
        <base-radio name="radio-1" radioId="radioId2" class="radio--lg">
          <template v-slot:label> 기간 선택 </template>
        </base-radio>
      </div>
    </div>

    <div class="ui-template__content">
      <h4 class="ui-template__title">Button Group</h4>
      <div class="button-group">
        <base-button class="button--lg button--danger button--left">
          <span class="button__text"> 취소 </span>
        </base-button>
        <base-button class="button--lg button--tertiary">
          <span class="button__text"> 닫기 </span>
        </base-button>
        <base-button class="button--lg button--primary">
          <span class="button__text"> 적용 </span>
        </base-button>
        <base-button class="button--lg button--right button--danger">
          <span class="button__text"> 목록 </span>
        </base-button>
      </div>
    </div>
  </div>
</template>
<i18n src="./ui-template.json"></i18n>
<script type="text/javascript">
import BaseRadio from "@component/styled/atoms/base-radio/base-radio";
import BaseButton from "@component/styled/atoms/base-button/base-button";
import { mapGetters } from "vuex";
export default {
  name: "UiTemplate",
  layout: "sample",
  extends: {},
  props: {
    radioId1: {
      type: String,
      default: null
    },
    radioId2: {
      type: String,
      default: null
    },
    theme: {
      type: String
    },
    size: {
      type: String,
      default: null
    },
    name: {
      type: String,
      default: null
    },
    radiosClass: {
      type: String,
      default: null
    },
    bar: {},
    foo: {},
    fooBar: {}
  },
  computed: {
    ...mapGetters({
      contents: "sample/search/contents"
    })
  },
  components: { BaseButton, BaseRadio },
  watch: {},
  methods: {}
};
</script>

<style lang="scss" scoped>
@import "./ui-template.scss";
</style>
