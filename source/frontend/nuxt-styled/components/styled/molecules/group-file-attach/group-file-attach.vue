<template lang="html">
  <div class="file-attach-group">
    <div class="file-attach-list">
      <div class="file-attach">
        <div class="file-attach__text-input">
          <input type="text" id="file-name1" class="file-attach__input" placeholder="권장이미지 사이즈 290 X auto"
                 readonly="readonly" title="첨부파일 경로"/>
          <base-button class="button--sm button--icon button--link file-attach__delete-button">
            <svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon>
            <span class="hidden">첨부파일 삭제</span>
          </base-button>
        </div>
        <div class="file-attach__file-input">
          <base-button class="button--lg button--tertiary">
            <label for="file-find">파일선택</label>
          </base-button>
          <input type="file" id="file-find1" class="file-attach__hidden-input"
                 onchange="javascript: document.getElementById('file-name1').value = this.value" title="첨부파일찾기"/>
        </div>
        <base-button class="button--lg button--tertiary button--icon button--danger file-attach__delete-row">
          <svg-icon class="svg-icon" name="minus" aria-hidden="true"></svg-icon>
          <span class="hidden">파일찾기 행삭제</span></base-button>
      </div>
      <div class="file-attach">
        <div class="file-attach__text-input">
          <input type="text" id="file-name" class="file-attach__input" placeholder="권장이미지 사이즈 290 X auto"
                 readonly="readonly" title="첨부파일 경로"/>
          <base-button class="button--sm button--icon button--link file-attach__delete-button">
            <svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon>
            <span class="hidden">첨부파일 삭제</span>
          </base-button>
        </div>
        <div class="file-attach__file-input">
          <base-button class="button--lg button--tertiary">
            <label for="file-find">파일선택</label>
          </base-button>
          <input type="file" id="file-find" class="file-attach__hidden-input"
                 onchange="javascript: document.getElementById('file-name').value = this.value" title="첨부파일찾기"/>
        </div>
        <base-button class="button--lg button--tertiary button--icon button--danger file-attach__delete-row">
          <svg-icon class="svg-icon" name="minus" aria-hidden="true"></svg-icon>
          <span class="hidden">파일찾기 행삭제</span></base-button>
      </div>
    </div>
    <base-button class="button--lg button--tertiary button--icon button--support file-attach__add-row">
      <svg-icon class="svg-icon" name="plus" aria-hidden="true"></svg-icon>
      <span class="hidden">파일찾기 행추가</span></base-button>
  </div>
</template>

<script type="text/javascript">
import BaseButton from "@atoms/base-button/base-button.vue";

export default {
  name: "GroupFileAttach",
  components: {
    BaseButton
  }
};
</script>

<style lang="scss" scoped>
@import "./group-file-attach";
</style>
