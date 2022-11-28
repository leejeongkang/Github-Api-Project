import BaseCheckbox from "./base-checkbox.vue";

export default {
  title: 'Styled/Atoms/[PCFI] 체크 박스',
  components: BaseCheckbox,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Checkbox Input Element </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: {BaseCheckbox},
  template:
    `
      <div class="checkboxs">
        <BaseCheckbox name="checkbox-test" checkboxId="checkbox1">
        <template v-slot:label>Basic Checkbox</template>
        </BaseCheckbox>
        <BaseCheckbox name="checkbox-test" checkboxId="checkbox2">
        <template v-slot:label>Basic Checkbox</template>
        </BaseCheckbox>
      </div>
    `,
});

export const CheckboxToggle = () => ({
  components: {BaseCheckbox},
  template:
    `
      <div class="checkbox-toggle">
        <BaseCheckbox name="checkbox-toggle" checkboxId="checkbox-toggle-01">
          <template v-slot:label>Toggle Checkbox</template>
        </BaseCheckbox>
        <BaseCheckbox name="checkbox-toggle" checkboxId="checkbox-toggle-02">
          <template v-slot:label>Toggle Checkbox</template>
        </BaseCheckbox>
      </div>
    `,
});
