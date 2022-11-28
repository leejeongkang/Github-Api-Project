import BaseSwitch from "./base-switch.vue";
import StoriesContainer from "@component/stories-container";

export default {
  title: 'Styled/Atoms/[PCFC] 버튼 스위치',
  components: BaseSwitch,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Switch </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: {StoriesContainer, BaseSwitch},
  template:
  `
      <div class="v-group v-group--gap-12">
        <BaseSwitch></BaseSwitch>
        <BaseSwitch><label for="toggleSwitch1" class="toggle-switch__label">label</label></BaseSwitch>
        <BaseSelect class='select--borderless select--sm'></BaseSelect>
        <BaseSwitch class="toggle-switch--sm"></BaseSwitch>
        <BaseSwitch class="toggle-switch--sm"><label for="toggleSwitch1" class="toggle-switch__label">label</label></BaseSwitch>
      </div>
    `
});
