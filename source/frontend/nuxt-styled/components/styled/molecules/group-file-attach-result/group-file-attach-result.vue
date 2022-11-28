<template lang="html">
  <div class="attached-file">
    <div class="attached-file__top-bar">
      <h5 class="attached-file__title">첨부파일 목록</h5>
      <small>샘플데이터는 5MB 이내의 csv, excel 파일만 등록 가능합니다.</small>
      <base-button class="button--secondary">샘플데이터 추가</base-button>
    </div>
    <div class="attached-file__group scrollCustomize">
      <ul class="attached-file__list">
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            GUI_Visual_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">1,208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            한자연_Visual_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            데이터포털_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">1,208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            GUI_Visual_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">1,208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            한자연_Visual_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            데이터포털_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">1,208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            GUI_Visual_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">1,208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            한자연_Visual_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
        <li class="attached-file__item">
          <div class="attached-file__item-title">
            <svg-icon name="file_katech" class="svg-icon"></svg-icon>
            데이터포털_Concept_0520.ppt
          </div>
          <div class="attached-file__item-volume">1,208KB</div>
          <base-button class="button--link button--sm">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </base-button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script type="text/javascript">
import BaseButton from "@atoms/base-button/base-button.vue";

export default {
  name: "GroupFileAttachResult",
  components: {
    BaseButton
  }
};
</script>

<style lang="scss" scoped>
@import "./group-file-attach-result";
</style>
